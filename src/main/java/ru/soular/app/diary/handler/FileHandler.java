package ru.soular.app.diary.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    public static void saveFile(String path, String data) {
        try {
            Files.write(Paths.get(path), data.getBytes());
            ConsoleWriter.writeSuccess("Data has been successfully exported!");
        } catch (IOException e) {
            ConsoleWriter.writeError("Failed to save data to file! Error: " + e.getMessage());
        }
    }

    public static byte[] readFile(String path) {
        try {
            byte [] result = Files.readAllBytes(Paths.get(path));
            ConsoleWriter.writeSuccess("Data has been successfully imported!");

            return result;
        } catch (IOException e) {
            ConsoleWriter.writeError("Failed to read data from file! Maybe file path is incorrect?");
        }

        return null;
    }
}
