package ru.soular.app.diary.command;

import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.storage.AppStorage;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public class UpdateScore implements Command {
    private final AppStorage appStorage = Application.INSTANCE.getAppStorage();
    private final Student student;
    private final Score newScore;


    public UpdateScore(String firstName, String lastName, String subject, String grade) {
        this(firstName, lastName, subject, grade, LocalDate.now());
    }

    public UpdateScore(String firstName, String lastName, String subject, String grade, LocalDate date) {
        this.student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        this.newScore = Score.builder()
                .subject(subject)
                .grade(grade)
                .date(date)
                .build();
    }

    @Override
    public void execute() {
        if (!appStorage.studentExists(student)) {
            ConsoleWriter.writeError("Student " + student + " does not exist!");
            return;
        }

        Set<Score> scores = appStorage.getScores(student);

        Optional<Score> oldScore = scores.stream()
                .filter(s -> s.getDate().equals(newScore.getDate()))
                .filter(s -> s.getSubject().equalsIgnoreCase(newScore.getSubject()))
                .findAny();

        if (oldScore.isPresent()) {
            scores.remove(oldScore.get());
            scores.add(newScore);
            ConsoleWriter.writeSuccess("Score has been successfully updated!");
            return;
        }

        scores.add(newScore);
        ConsoleWriter.writeSuccess("Score has been successfully created!");
    }
}
