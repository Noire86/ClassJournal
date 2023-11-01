package ru.soular.app.diary.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
