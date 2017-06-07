import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileProcessor {

    private StringProcessor stringProcessor = new StringProcessor();

    public Map<Integer, List<Word>> readWordsFromFile(String pathToFile) {
        Map<Integer, List<Word>> wordsInString = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            wordsInString = stringProcessor.processString(reader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return wordsInString;
    }

    public void writeOutputToFile(String pathToFile, String input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile, true))) {
            writer.write(input + "\r\n" );
            writer.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
