package ru.soular.app.diary.command;

import lombok.extern.slf4j.Slf4j;
import ru.soular.app.diary.Main;
import ru.soular.app.diary.handler.ConsoleWriter;

public class Exit implements Command {
    @Override
    public void execute() {
        ConsoleWriter.writeHelp("See you soon!");
        Main.EXIT = true;
    }
}
