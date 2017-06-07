import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringProcessor {

    private WordAnalyzer wordAnalyzer = new WordAnalyzer();

    public Map<Integer, List<Word>> processString(String input) {
        String regex = "[^a-zA-Z ]";
        Map<Integer, List<Word>> words = Arrays.stream(input.replaceAll(regex, "").toLowerCase().split(" "))
            .map(word -> wordAnalyzer.buildWordObject(word))
            .collect(Collectors.groupingBy(Word::getNumberOfLetters));
        return words;
    }
}
