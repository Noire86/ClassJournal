package ru.soular.app.diary.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName.toLowerCase(), student.firstName.toLowerCase())
                && Objects.equals(lastName.toLowerCase(), student.lastName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
}
