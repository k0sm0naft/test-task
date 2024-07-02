package test.service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import test.service.Writer;

public class FileWriter implements Writer {
    private final String fileName = "output.txt";

    @Override
    public void write(String answer) {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(answer);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file. File=" + fileName, e);
        }
    }
}
