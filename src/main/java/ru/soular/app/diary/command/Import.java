package ru.soular.app.diary.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.SerializationUtils;
import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.handler.FileHandler;
import ru.soular.app.diary.storage.AppStorage;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class Import implements Command {

    private final String path;

    @Override
    public void execute() {
        AppStorage appStorage = Application.INSTANCE.getAppStorage();

        try {
            appStorage.setData(SerializationUtils.deserialize(FileHandler.readFile(path)));
        } catch (Exception e) {
            ConsoleWriter.writeError("Error on mapping database from file: " + e.getMessage());
        }
    }
}
