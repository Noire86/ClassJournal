package ru.soular.app.diary.command;

import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.storage.AppStorage;

public class AddStudent implements Command {

    private final AppStorage appStorage = Application.INSTANCE.getAppStorage();
    private final Student newStudent;

    public AddStudent(String firstName, String lastName) {
        this.newStudent = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    @Override
    public void execute() {
        if (appStorage.studentExists(newStudent)) {
            ConsoleWriter.writeError("Student " + newStudent + " already exists!");
            return;
        }

        appStorage.addStudent(newStudent);
        ConsoleWriter.writeSuccess("Student " + newStudent + " has been successfully added!");
    }
}
