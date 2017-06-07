package com.myproject.model;

import java.util.Set;

public class Word implements Comparable<Word> {

    private Set<String> vowels;
    private int numberOfLetters;
    private int numberOfVowels;

    public Set<String> getVowels() {
        return vowels;
    }

    public void setVowels(Set<String> vowels) {
        this.vowels = vowels;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public void setNumberOfLetters(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public void setNumberOfVowels(int numberOfVowels) {
        this.numberOfVowels = numberOfVowels;
    }

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
