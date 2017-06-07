import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class WordAnalyzer {

    public Word buildWordObject(String inputWord) {
        Word word = new Word();
        word.setNumberOfLetters(inputWord.length());
        Character[] vowelsInWord = findVowelsInWord(inputWord);
        word.setNumberOfVowels(vowelsInWord.length);
        Set<Character> distinctVowelsInWord = new TreeSet<>();
        distinctVowelsInWord.addAll(Arrays.asList(vowelsInWord));
        word.setVowels(distinctVowelsInWord);
        return word;
    }

    private Character[] findVowelsInWord(String inputWord) {
        String vowels = "aeiou";
        Character[] vowelsInWord = inputWord.chars().mapToObj(letter -> (char) letter)
            .filter(letter -> vowels.contains(letter.toString()))
            .toArray(Character[]::new);
        return vowelsInWord;
    }
}
