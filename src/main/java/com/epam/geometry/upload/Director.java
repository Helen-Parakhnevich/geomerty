package com.epam.geometry.upload;

import com.epam.geometry.entity.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Director {

    private DataReader reader;
    private DataValidator dataValidator;
    private TriangleCreator triangleCreator;

    private List<Triangle> read(String path) {

        List<Triangle> triangleList = Arrays.asList();

        List<String> stringListPoints = DataReader.readFile(path);

        for (String line: stringListPoints) {
            if (dataValidator.isValidLine(line)) {
                Triangle newTriangle = TriangleCreator.createObject(line);
                triangleList.add(newTriangle);
            }
        }

        return triangleList;
    }


}
