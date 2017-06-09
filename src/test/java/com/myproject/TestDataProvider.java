package com.myproject;

import com.myproject.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestDataProvider {

    public static final int NUMBER_OF_LETTERS_1 = 6;
    public static final int NUMBER_OF_LETTERS_2 = 4;
    public static final int NUMBER_OF_VOWELS = 2;
    public static final String VOWEL_1 = "a";
    public static final String VOWEL_2 = "o";
    public static final String VOWEL_3 = "e";
    public static final String TEST_STRING = "Platon, made.";
    public static final String OUTPUT_1 = "({a, o}, 6) -> 2,0\r\n";
    public static final String OUTPUT_2 = "({a, e}, 4) -> 2,0\r\n";

    public static List<Word> getListOfWords() {
        List<Word> listOfWords = new ArrayList<>();
        Set<String> vowels_1 = new TreeSet<>();
        vowels_1.add(VOWEL_1);
        vowels_1.add(VOWEL_2);
        Set<String> vowels_2 = new TreeSet<>();
        vowels_2.add(VOWEL_1);
        vowels_2.add(VOWEL_3);
        Word word_1 = new Word(vowels_1, NUMBER_OF_LETTERS_1, NUMBER_OF_VOWELS);
        Word word_2 = new Word(vowels_2, NUMBER_OF_LETTERS_2, NUMBER_OF_VOWELS);
        listOfWords.add(word_1);
        listOfWords.add(word_2);
        return listOfWords;
    }
}
