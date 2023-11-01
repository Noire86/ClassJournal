package ru.soular.app.diary.command;

import ru.soular.app.diary.handler.ConsoleWriter;

public class Motd implements Command {

    @Override
    public void execute() {
        ConsoleWriter.writeHelp(Help.DELIMITER);
        ConsoleWriter.writeHelp("""
                 Welcome to the School Diary app!\s
                 With this simple application, you can\s
                 rest assured about your students grades and scores!\s
                 
                 Just type 'help' command in the shell to see available commands and features!
                 You can exit the application by simply typing an 'exit' command.""");
        ConsoleWriter.writeHelp(Help.DELIMITER);
    }
}
