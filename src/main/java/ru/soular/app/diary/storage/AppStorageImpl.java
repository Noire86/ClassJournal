package ru.soular.app.diary.storage;

import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;

import java.util.*;

public enum AppStorageImpl implements AppStorage {
    INSTANCE;

    AppStorageImpl() {
        this.database = new HashMap<>();
    }

    private final Map<Student, Set<Score>> database;

    @Override
    public Set<Score> getScores(Student student) {
        return database.get(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return database.keySet()
                .stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .toList();
    }

    @Override
    public Boolean studentExists(Student student) {
        return database.containsKey(student);
    }

    @Override
    public void addStudent(Student student) {
        database.put(student, new HashSet<>());
    }

    @Override
    public void removeStudent(Student student) {
        database.remove(student);
    }

    @Override
    public Map<Student, Set<Score>> getData() {
        return database;
    }

    @Override
    public void setData(Map<Student, Set<Score>> map) {
        database.clear();
        database.putAll(map);
    }
}
