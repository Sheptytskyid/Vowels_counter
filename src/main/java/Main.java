import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        OutputGenerator outputGenerator = new OutputGenerator();
        Map<Integer, List<Word>> words = fileProcessor.readWordsFromFile("INPUT.TXT");
        outputGenerator.generateOutput(words);
    }
}
