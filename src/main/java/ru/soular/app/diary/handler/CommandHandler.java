package ru.soular.app.diary.handler;

import ru.soular.app.diary.command.Exit;
import lombok.extern.slf4j.Slf4j;
import ru.soular.app.diary.command.Help;
import ru.soular.app.diary.command.Motd;

public class CommandHandler {

    public void processCommand(String line) {

        switch (line.trim().toLowerCase()) {

            case "help" -> new Help().execute();
            case "exit" -> new Exit().execute();
            case "motd" -> new Motd().execute();

            default -> ConsoleWriter.writeError("No such command! Use 'help' to list available commands");
        }
    }
}
