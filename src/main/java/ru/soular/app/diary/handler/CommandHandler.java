package ru.soular.app.diary.handler;

import ru.soular.app.diary.command.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CommandHandler {

    public void processCommand(String line) {
        if (line == null || line.isEmpty()) {
            printError();
            return;
        }

        String[] args = line.split(" ");
        switch (args[0].trim().toLowerCase()) {

            case "addstudent" -> {
                if (args.length != 3) {
                    printInvalidArgs();
                    return;
                }

                new AddStudent(args[1], args[2]).execute();
            }

            case "delstudent" -> {
                if (args.length != 3) {
                    printInvalidArgs();
                    return;
                }

                new DelStudent(args[1], args[2]).execute();
            }

            case "showscore" -> {
                if (args.length != 3) {
                    printInvalidArgs();
                    return;
                }

                new ShowScore(args[1], args[2]).execute();
            }

            case "updatescore" -> {
                if (args.length == 6) {
                    try {
                        LocalDate date = LocalDate.parse(args[5], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        new UpdateScore(args[1], args[2], args[3], args[4], date).execute();

                    } catch (DateTimeParseException ex) {
                        ConsoleWriter.writeError("Invalid date format! Please format the date as follows: 01-01-2001");
                    }
                } else if (args.length == 5) {
                    new UpdateScore(args[1], args[2], args[3], args[4]).execute();

                } else {
                    printInvalidArgs();
                }
            }

            case "export" -> {
                if (args.length != 2) {
                    printInvalidArgs();
                    return;
                }

                new Export(args[1]).execute();
            }

            case "import" -> {
                if (args.length != 2) {
                    printInvalidArgs();
                    return;
                }

                new Import(args[1]).execute();
            }

            case "showallscores" -> new ShowAllScores().execute();
            case "help" -> new Help().execute();
            case "exit" -> new Exit().execute();
            case "motd" -> new Motd().execute();

            default -> printError();
        }

    }

    private void printError() {
        ConsoleWriter.writeError("Invalid command! Check command arguments, or use 'help' to list available commands");
    }

    private void printInvalidArgs() {
        ConsoleWriter.writeError("Invalid command arguments! Use 'help' to find out how to use this command");
    }
}
