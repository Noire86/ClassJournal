package ru.soular.app.diary.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Score {
    private String subject;
    private Character grade;
}
