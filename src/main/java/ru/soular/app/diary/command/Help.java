package ru.soular.app.diary.command;

import ru.soular.app.diary.handler.ConsoleWriter;

public class Help implements Command {

    public static final String DELIMITER = "===============================================";

    @Override
    public void execute() {
        ConsoleWriter.writeHelp(DELIMITER);
        ConsoleWriter.writeHelp("""
                Available commands:
                - addStudent {firstName} {lastName} | Add new student
                - delStudent {firstName} {lastName} | Remove student
                - updateScore {firstName} {lastName} {subject} {grade} {date} | Update student`s score for specific subject and date
                - updateScore {firstName} {lastName} {subject} {grade} | Create new student`s score
                - showAllScores | Show all students and their scores
                - showScore {firstName} {lastName} | Show scores for a specific student
                - help | Print help menu
                - motd | Print welcoming message
                - export | Export data to file
                - import {path} Import data to file
                - exit | Exit application""");
        ConsoleWriter.writeHelp(DELIMITER);
    }
}
