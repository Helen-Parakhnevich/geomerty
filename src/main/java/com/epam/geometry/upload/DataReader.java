package com.epam.geometry.upload;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DataReader {

    public static List<String> readFile(String path) {
        List<String> dataList = Arrays.asList();

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                dataList.add(line);
            }

        } catch (IOException e) {
        }
        return dataList;
    }

}
