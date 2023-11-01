package ru.soular.app.diary.command;

import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.storage.AppStorage;

public class DelStudent implements Command {

    private final AppStorage appStorage = Application.INSTANCE.getAppStorage();
    private final Student student;

    public DelStudent(String firstName, String lastName) {
        this.student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    @Override
    public void execute() {
        if (appStorage.studentExists(student)) {
            appStorage.removeStudent(student);
            ConsoleWriter.writeSuccess("Student " + student + " has been successfully removed!");
            return;
        }

        ConsoleWriter.writeSuccess("Student " + student + " does not exist!");
    }
}
