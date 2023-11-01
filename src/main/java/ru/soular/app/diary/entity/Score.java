package ru.soular.app.diary.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Score {
    private String subject;
    private String grade;
    private LocalDate date;
}
