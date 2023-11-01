package ru.soular.app.diary.command;

import ru.soular.app.diary.handler.ConsoleWriter;

public class Help implements Command {

    public static final String DELIMITER = "===============================================";

    @Override
    public void execute() {
        ConsoleWriter.writeHelp(DELIMITER);
        ConsoleWriter.writeHelp("""
                Available commands:
                - addStudent {student} | Add new student
                - delStudent {student} | Remove student
                - updateScore {student} {subject} {score} | Update student`s score for specific subject
                - showAllScores | Show all students and their scores
                - showScore {student} | Show scores for a specific student
                - help | Print help menu
                - motd | Print welcoming message
                - exit | Exit application""");
        ConsoleWriter.writeHelp(DELIMITER);
    }
}
