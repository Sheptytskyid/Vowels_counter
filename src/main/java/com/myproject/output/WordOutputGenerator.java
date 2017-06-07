package com.myproject.output;

import com.myproject.io.FileIo;
import com.myproject.model.Word;
import com.sun.deploy.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WordOutputGenerator implements OutputGenerator<Word> {

    private FileIo fileIo;

    @Autowired
    public WordOutputGenerator(FileIo fileIo) {
        this.fileIo = fileIo;
    }

    @Override
    public void printOutput(List<Word> input) {
        Map<Word, List<Integer>> groupedVowels = prepareOutput(input);
        StringBuilder output = new StringBuilder();
        for (Word word : groupedVowels.keySet()) {
            Double rate = groupedVowels.get(word).stream().mapToInt(val -> val).sum() * 1d / groupedVowels.get(word).size();
            output.append(String.format("({%s}, %d) -> %f%n",
                StringUtils.join(word.getVowels(), ", "), word.getNumberOfLetters(), rate));
        }
        fileIo.write(output.toString());
    }

    private Map<Word, List<Integer>> prepareOutput(List<Word> input) {
        Map<Word, List<Integer>> groupedVowels = new LinkedHashMap<>();
        List<Integer> totalNumberOfVowels;
        for (Word word : input) {
            if (groupedVowels.containsKey(word)) {
                groupedVowels.get(word).add(word.getNumberOfVowels());
            } else {
                totalNumberOfVowels = new ArrayList<>();
                totalNumberOfVowels.add(word.getNumberOfVowels());
                groupedVowels.put(word, totalNumberOfVowels);
            }
        }
        return sortMapBeforeOutput(groupedVowels);
    }

    private Map<Word, List<Integer>> sortMapBeforeOutput(Map<Word, List<Integer>> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<Word, List<Integer>>comparingByKey().reversed())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
    }
}