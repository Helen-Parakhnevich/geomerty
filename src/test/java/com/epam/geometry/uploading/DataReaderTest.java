package com.epam.geometry.uploading;

import com.epam.geometry.uploading.DataReader;
import com.epam.geometry.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final static DataReader dataReader = new DataReader();

    @Test
    public void testReadFileWhenFileExists() throws IOException {
        //given
        String path = "src/test/resources/coordinates.txt";
        List<String> dataList = Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)");

        //when
        List<String> result = dataReader.readFile(path);

        //then
        Assert.assertEquals(dataList, result);
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadFileWhenFileNotExists() throws IOException {
        //given
        String path = "src/test/resources/coord.txt";
        List<String> dataList = Arrays.asList();

        //when
        List<String> result = dataReader.readFile(path);

        //then
        Assert.assertEquals(dataList, result);
    }
}