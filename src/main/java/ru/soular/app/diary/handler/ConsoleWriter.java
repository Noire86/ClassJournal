package ru.soular.app.diary.handler;

import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import ru.soular.app.diary.Application;

import java.io.PrintWriter;

public class ConsoleWriter {
    private static final Application app = Application.INSTANCE;

    public static void writeInfo(String msg) {
        writeColoredMessage(msg, AttributedStyle.BRIGHT);
    }

    public static void writeHelp(String msg) {
        writeColoredMessage(msg, AttributedStyle.WHITE);
    }

    public static void writeSuccess(String msg) {
        writeColoredMessage(msg, AttributedStyle.GREEN);
    }

    public static void writeWarn(String msg) {
        writeColoredMessage(msg, AttributedStyle.YELLOW);
    }

    public static void writeError(String err) {
        writeColoredMessage(err, AttributedStyle.RED);
    }

    private static void writeColoredMessage(String msg, int color) {
        PrintWriter writer = app.getTerminal().writer();
        writer.println(new AttributedStringBuilder()
                .style(AttributedStyle.DEFAULT
                        .italic()
                        .foreground(color)
                )
                .append(msg)
                .toAnsi()
        );

        writer.flush();
    }
}
