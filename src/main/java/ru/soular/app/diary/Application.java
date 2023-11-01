package ru.soular.app.diary;

import lombok.Getter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import ru.soular.app.diary.handler.CommandHandler;
import ru.soular.app.diary.storage.AppStorage;
import ru.soular.app.diary.storage.AppStorageImpl;

import java.io.IOException;

@Getter
public enum Application {
    INSTANCE(AppStorageImpl.INSTANCE);

    private final Terminal terminal;
    private final LineReader lineReader;
    private final CommandHandler commandHandler;
    private final AppStorage appStorage;

    Application(AppStorage appStorage) {
        try {
            this.appStorage = appStorage;
            this.commandHandler = new CommandHandler();
            this.terminal = TerminalBuilder.terminal();
            this.lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .parser(new DefaultParser())
                    .build();

        } catch (IOException ex) {
            throw new ExceptionInInitializerError();
        }
    }
}
