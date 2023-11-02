package ru.soular.app.diary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Score implements Serializable {
    private String subject;
    private String grade;
    private LocalDate date;
}
