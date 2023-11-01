package ru.soular.app.diary.command;

import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.storage.AppStorage;

public class ShowAllScores implements Command {

    private final AppStorage appStorage = Application.INSTANCE.getAppStorage();

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append(Help.DELIMITER);
        sb.append("\n");

        if (!appStorage.getAllStudents().isEmpty()) {
            appStorage.getAllStudents().forEach(student -> sb.append(prepareStudentString(student)));
        } else {
            sb.append("There are no students registered yet.");
        }

        sb.append("\n");
        sb.append(Help.DELIMITER);

        ConsoleWriter.writeInfo(sb.toString());
    }

    private String prepareStudentString(Student student) {
        StringBuilder scores = new StringBuilder();
        appStorage.getScores(student).forEach(score -> {
            scores.append(String.format("%s: %s (%s)\n", score.getSubject(), score.getGrade(), score.getDate()));
        });

        return "-------\n" +
                String.format("%s Scores: \n", student) +
                scores +
                "-------\n";
    }
}
