package com.myproject.processors;

import com.myproject.io.FileIo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.myproject.TestDataProvider.TEST_STRING;
import static com.myproject.TestDataProvider.getListOfWords;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordProcessorTest {
    @Mock
    private FileIo fileIo;
    @InjectMocks
    private WordProcessor wordProcessor;

    @Test
    public void processInputFromIoSource() throws Exception {
        when(fileIo.read()).thenReturn(TEST_STRING);
        assertEquals(getListOfWords(), wordProcessor.convertStringIntoListOfElements());
    }
}
