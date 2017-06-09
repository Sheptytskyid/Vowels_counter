package com.myproject.output;

import com.myproject.io.FileIo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.myproject.TestDataProvider.OUTPUT_1;
import static com.myproject.TestDataProvider.OUTPUT_2;
import static com.myproject.TestDataProvider.getListOfWords;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WordOutputGeneratorTest {
    @Mock
    private FileIo fileIo;
    @InjectMocks
    private WordOutputGenerator wordOutputGenerator;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void printOutput() throws Exception {
        wordOutputGenerator.printOutput(getListOfWords());
        String output = OUTPUT_1 + OUTPUT_2;
        verify(fileIo, times(1)).write(output);
    }

}