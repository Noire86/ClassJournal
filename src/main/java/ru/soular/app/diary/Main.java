package ru.soular.app.diary;

import ru.soular.app.diary.command.Motd;

public class Main {

    public static boolean EXIT = false;

    public static void main(String[] args)  {
        Application application = Application.INSTANCE;
        new Motd().execute();

        while (!EXIT) {
            String newLine = application.getLineReader().readLine("> ");
            application.getCommandHandler().processCommand(newLine);
            application.getLineReader().getHistory().add(newLine);

            if (EXIT) {
                System.exit(0);
            }
        }
    }
}
