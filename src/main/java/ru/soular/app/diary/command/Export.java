package ru.soular.app.diary.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.SerializationUtils;
import ru.soular.app.diary.Application;
import ru.soular.app.diary.entity.Score;
import ru.soular.app.diary.entity.Student;
import ru.soular.app.diary.handler.ConsoleWriter;
import ru.soular.app.diary.handler.FileHandler;
import ru.soular.app.diary.storage.AppStorage;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class Export implements Command {

    private final String path;

    @Override
    public void execute() {
        try {
            AppStorage appStorage = Application.INSTANCE.getAppStorage();
            FileHandler.saveFile(path, SerializationUtils.serialize((Serializable) appStorage.getData()));
        } catch (Exception e) {
            ConsoleWriter.writeError("Error on mapping database to file: " + e.getMessage());
        }

    }
}
