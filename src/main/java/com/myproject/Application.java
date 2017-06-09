package com.myproject;

import com.myproject.model.Word;
import com.myproject.output.OutputGenerator;
import com.myproject.processors.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private Processor<Word> processor;
    private OutputGenerator<Word> generator;

    @Autowired
    public Application(Processor<Word> processor, OutputGenerator<Word> generator) {
        this.processor = processor;
        this.generator = generator;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Word> words = processor.convertStringIntoListOfElements();
        generator.printOutput(words);
    }
}
