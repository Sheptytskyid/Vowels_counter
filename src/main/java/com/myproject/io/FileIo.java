package com.myproject.io;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileIo implements Io {
    @Value("${input.file.name}")
    private String INPUT_FILE;
    @Value("${output.file.name}")
    private String OUTPUT_FILE;

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
            log.error("Error reading from file" + exception.getMessage());
        }
        log.info("Input successfully read");
        return fileContent.toString();
    }

    @Override
    public void write(String input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            log.info("Writing output to file");
            writer.write(input + "\r\n" );
            writer.flush();
        } catch (IOException exception) {
            log.error("Error writing to file" + exception.getMessage());
        }
        log.info("Output saved to file");
    }
}
