package ru.soular.app.diary.storage;

import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;

import java.util.List;
import java.util.Map;

public interface AppStorage {
    List<Score> getScores(Student student);
    List<Student> getAllStudents();
    Boolean studentExists(Student student);
    void addStudent(Student student);
    void removeStudent(Student student);
}
