import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputGenerator {

    FileProcessor fileProcessor = new FileProcessor();

    public void generateOutput(Map<Integer, List<Word>> input){
        int counter = 1;
        for (Map.Entry<Integer, List<Word>> word : input.entrySet()) {
            Map<Set<Character>, Double> output = new HashMap<>();
            for (Word value : word.getValue()) {
                if (output.containsKey(value.getVowels())) {
                    output.put(value.getVowels(), (output.get(value.getVowels()) + (double) value.getNumberOfVowels()) / ++counter);
                } else {
                    output.put(value.getVowels(), (double) value.getNumberOfVowels());
                }
            }
            output.forEach((key, value) -> fileProcessor.writeOutputToFile("OUTPUT.TXT", key.toString() + "," + value + "->" + word.getKey()));
        }
    }
}
