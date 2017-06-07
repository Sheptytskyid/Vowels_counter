package processors;

import io.FileIo;
import model.Word;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordProcessor implements Processor<Word> {

    private FileIo fileIo = new FileIo();
    private String regexp = "[^a-zA-Z ]";
    private String consonants = "[^aeiou]";

    @Override
    public List<Word> processInputFromIoSource() {
        String input = fileIo.read();
        return Arrays.stream(input.replaceAll(regexp, "").toLowerCase().split("\\s+"))
                    .map(this::convertInputToWordObject)
                    .collect(Collectors.toList());
    }

    private Word convertInputToWordObject(String inputWord) {
        String vowels = getVowelsFromWord(inputWord);
        Set<String> distinctVowels = Arrays.stream(vowels.split("")).collect(Collectors.toSet());
        Word wordObject = new Word();
        wordObject.setNumberOfLetters(inputWord.length());
        wordObject.setNumberOfVowels(vowels.length());
        wordObject.setVowels(distinctVowels);
        return wordObject;
    }

    private String getVowelsFromWord(String word) {
        return word.replaceAll(consonants, "");
    }
}
