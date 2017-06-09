package com.myproject.io;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileIo implements Io {
    private static final String INPUT_FILE = "INPUT.TXT";
    private static final String OUTPUT_FILE = "OUTPUT.TXT";

    private org.slf4j.Logger log = LoggerFactory.getLogger(FileIo.class);

    @Override
    public String read() {
        log.info("Reading input prom file");
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            while (reader.ready()) {
                fileContent.append(reader.readLine());
            }
        } catch (IOException exception) {
            log.error(String.format("Error reading from file - %s", exception.getMessage()), exception);
        }
        log.info("Input successfully read");
        return fileContent.toString();
    }

    @Override
    public void write(String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            log.info("Writing output to file");
            writer.write(output + "\r\n");
            writer.flush();
        } catch (IOException exception) {
            log.error(String.format("Error writing to file - %s", exception.getMessage()), exception);
        }
        log.info("Output saved to file");
    }
}
