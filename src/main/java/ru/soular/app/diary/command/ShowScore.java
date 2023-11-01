package ru.soular.app.diary.command;

import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.storage.AppStorage;

public class ShowScore implements Command {

    private final AppStorage appStorage = Application.INSTANCE.getAppStorage();
    private final Student student;

    public ShowScore(String firstName, String lastName) {
        this.student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append(Help.DELIMITER);
        sb.append("\n");

        if (appStorage.studentExists(student)) {
            sb.append(prepareStudentString(student));
        } else {
            sb.append("Student ").append(student).append(" does not exist!");
        }

        sb.append("\n");
        sb.append(Help.DELIMITER);

        ConsoleWriter.writeInfo(sb.toString());
    }

    private String prepareStudentString(Student student) {
        StringBuilder scores = new StringBuilder();
        appStorage.getScores(student).forEach(score -> {
            scores.append("%s: %s\n");
        });

        return String.format("-------\n" +
                        "%s Scores: \n" +
                        scores +
                        "-------\n"
                , student);
    }
}
