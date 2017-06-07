import model.Word;
import output.OutputGeneratorImpl;
import processors.WordProcessor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        WordProcessor processor = new WordProcessor();
        OutputGeneratorImpl generator = new OutputGeneratorImpl();
        List<Word> words = processor.processInputFromIoSource();
        generator.printOutput(words);
    }
}
