package com.epam.geometry.uploading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class DataReader {

    private final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public List<String> readFile(String path) throws IOException {
        List<String> dataList = new ArrayList<String>();
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            LOGGER.error(e);
            throw e;
        } finally {
                if (nonNull(bufferedReader)) {
                    bufferedReader.close();
                }
        }

        return dataList;
    }

}
