package com.myproject.output;

import com.myproject.io.FileIo;
import com.myproject.model.Word;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WordOutputGeneratorTest {

    private static final int NUMBER_OF_LETTERS = 5;
    private static final int NUMBER_OF_VOWELS = 2;
    private static final String VOWEL_1 = "a";
    private static final String VOWEL_2 = "o";
    private final double RATE = NUMBER_OF_VOWELS;
    private final String OUTPUT = String.format("({%s}, %d) -> %.1f%n", VOWEL_1 + ", " + VOWEL_2, NUMBER_OF_LETTERS,
        RATE);

    @Mock
    private FileIo fileIo;
    @InjectMocks
    private WordOutputGenerator wordOutputGenerator;
    private List<Word> inputList;
    private Set<String> vowels;

    @Before
    public void setUp() throws Exception {
        inputList = new ArrayList<>();
        vowels = new TreeSet<>();
        vowels.add(VOWEL_1);
        vowels.add(VOWEL_2);
        Word word = new Word();
        word.setNumberOfLetters(NUMBER_OF_LETTERS);
        word.setNumberOfVowels(NUMBER_OF_VOWELS);
        word.setVowels(vowels);
        inputList.add(word);

    }

    @Test
    public void printOutput() throws Exception {
        wordOutputGenerator.printOutput(inputList);
        verify(fileIo, times(1)).write(OUTPUT);
    }

}