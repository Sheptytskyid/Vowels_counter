package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIo implements Io {

    private static final String INPUT_FILE = "INPUT.TXT";
    private static final String OUTPUT_FILE = "OUTPUT.TXT";

    @Override
    public String read() {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            while (reader.ready()) {
                fileContent.append(reader.readLine());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return fileContent.toString();
    }

    @Override
    public void write(String input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write(input + "\r\n" );
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
