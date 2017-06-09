package com.myproject.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static com.myproject.TestDataProvider.TEST_STRING;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileIo.class)
public class FileIoTest {
    @Mock
    private BufferedWriter writerMock;
    @Mock
    private BufferedReader readerMock;
    @Mock
    private FileInputStream inputStreamMock;
    @Mock
    private FileOutputStream outputStreamMock;
    @InjectMocks
    private FileIo fileIo;

    @Before
    public void setUp() throws Exception {
        whenNew(BufferedReader.class).withArguments(Matchers.any()).thenReturn(readerMock);
        whenNew(BufferedWriter.class).withArguments(Matchers.any()).thenReturn(writerMock);
        whenNew(FileInputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(inputStreamMock);
        whenNew(FileOutputStream.class).withParameterTypes(String.class).withArguments(Matchers.any()).thenReturn(outputStreamMock);
    }

    @Test
    public void readShouldReturnString() throws Exception {
        PowerMockito.when(readerMock.ready()).thenReturn(true).thenReturn(false);
        PowerMockito.when(readerMock.readLine()).thenReturn(TEST_STRING);
        assertEquals(TEST_STRING, fileIo.read());
        verify(readerMock, times(2)).ready();
        verify(readerMock, times(1)).readLine();
    }

    @Test
    public void write() throws Exception {
        fileIo.write(TEST_STRING);
        Mockito.verify(writerMock, times(1)).write(TEST_STRING + "\r\n");
        Mockito.verify(writerMock, times(1)).flush();
    }

}