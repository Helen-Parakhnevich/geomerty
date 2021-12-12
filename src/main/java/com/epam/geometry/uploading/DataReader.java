package com.epam.geometry.uploading;

import com.epam.geometry.service.HandledException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class DataReader {

    public List<String> readFile(String path) throws HandledException {
        List<String> dataList = new ArrayList<String>();
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            throw new HandledException(e.getMessage(), e);
        } finally {
            try {
                if (nonNull(bufferedReader)) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new HandledException(e.getMessage(), e);
            }
        }

        return dataList;
    }

}
