package com.myproject.processors;

import com.myproject.io.FileIo;
import com.myproject.model.Word;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class WordProcessor implements Processor<Word> {

    private String regexp = "[^a-zA-Z ]";
    private String consonants = "[^aeiou]";

    private FileIo fileIo;
    private org.slf4j.Logger log = LoggerFactory.getLogger(WordProcessor.class);


    @Autowired
    public WordProcessor(FileIo fileIo) {
        this.fileIo = fileIo;
    }

    @Override
    public List<Word> processInputFromIoSource() {
        log.info("Processing input from IO source");
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
