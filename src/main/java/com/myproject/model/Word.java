package com.myproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word implements Comparable<Word> {
    private Set<String> vowels;
    private int numberOfLetters;
    private int numberOfVowels;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Word word = (Word) o;

        if (numberOfLetters != word.numberOfLetters) {
            return false;
        }
        return vowels.equals(word.vowels);
    }

    @Override
    public int hashCode() {
        int result = vowels.hashCode();
        result = 31 * result + numberOfLetters;
        return result;
    }

    @Override
    public int compareTo(Word word) {
        return this.numberOfLetters - word.getNumberOfLetters();
    }
}
