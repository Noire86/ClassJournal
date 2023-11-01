package ru.soular.app.diary.storage;

import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AppStorage {
    Set<Score> getScores(Student student);
    List<Student> getAllStudents();
    Boolean studentExists(Student student);
    void addStudent(Student student);
    void removeStudent(Student student);
    Map<Student, Set<Score>> getData();
    void setData(Map<Student, Set<Score>> map);
}
