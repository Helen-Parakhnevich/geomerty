package com.epam.geometry.core.uploading;

import com.epam.geometry.uploading.DataReader;
import com.epam.geometry.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    @Test
    public void testReadFileWhenFileExists() throws HandledException {
        //given
        DataReader dataReader = new DataReader();
        String path = "/Users/Helen/Documents/JAVA/projects/geomerty/src/test/resources/coordinates.txt";
        List<String> dataList = Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)");
        //when
        List<String> result = dataReader.readFile(path);

        //then
        Assert.assertEquals(dataList, result);
    }

    @Test(expected = HandledException.class)
    public void testReadFileWhenFileNotExists() throws HandledException {
        DataReader dataReader = new DataReader();
        String path = "/Users/Helen/Documents/JAVA/projects/geomerty/src/test/resources/coord.txt";
        List<String> dataList = Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)");
        //when
        List<String> result = dataReader.readFile(path);

    }
}
