package ru.soular.app.diary.storage;

import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AppStorageImpl implements AppStorage {
    INSTANCE;

    AppStorageImpl() {
        this.database = new HashMap<>();
    }

    private final Map<Student, List<Score>> database;

    @Override
    public List<Score> getScores(Student student) {
        return database.get(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return database.keySet()
                .stream()
                .sorted()
                .toList();
    }

    @Override
    public Boolean studentExists(Student student) {
        return database.containsKey(student);
    }

    @Override
    public void addStudent(Student student) {
        database.put(student, new ArrayList<>());
    }

    @Override
    public void removeStudent(Student student) {
        database.remove(student);
    }
}
