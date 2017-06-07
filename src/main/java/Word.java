import lombok.Data;

import java.util.Set;

@Data
public class Word implements Comparable<Word> {

    private int numberOfLetters;
    private int numberOfVowels;
    private Set<Character> vowels;

    @Override
    public int compareTo(Word word) {
        return word.getNumberOfLetters() - this.numberOfLetters;
    }
}
