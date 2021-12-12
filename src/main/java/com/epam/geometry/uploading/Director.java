package com.epam.geometry.uploading;

import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Director {

    private final DataReader dataReader;
    private final DataValidator dataValidator;
    private final TriangleCreator triangleCreator;

    public Director(DataReader reader, DataValidator validator, TriangleCreator creator) {
        this.dataValidator = validator;
        this.dataReader = reader;
        this.triangleCreator = creator;
    }

    public List<Triangle> read(String path) throws HandledException {
        List<Triangle> triangleList = new ArrayList<>();
        List<String> stringListPoints = dataReader.readFile(path);

        for (String line : stringListPoints) {
            if (dataValidator.isValidLine(line)) {
                Optional<Triangle> newTriangle = triangleCreator.createObject(line);
                if (newTriangle.isPresent()) {
                    triangleList.add(newTriangle.get());
                }
                else {
                    throw new HandledException("Not a valid string: " + line);
                }
            }
        }

        return triangleList;
    }

}
