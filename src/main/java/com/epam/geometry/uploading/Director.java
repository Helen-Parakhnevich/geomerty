package com.epam.geometry.uploading;

import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Director {

    private final DataReader dataReader;
    private final DataValidator dataValidator;
    private final TriangleCreator triangleCreator;
    private final Logger LOGGER = LogManager.getLogger(HandledException.class);

    public Director(DataReader reader, DataValidator validator, TriangleCreator creator) {
        this.dataValidator = validator;
        this.dataReader = reader;
        this.triangleCreator = creator;
    }

    public List<Triangle> read(String path) throws HandledException, IOException {
        List<Triangle> triangleList = new ArrayList<>();
        List<String> stringListPoints = dataReader.readFile(path);

        for (String line : stringListPoints) {
            if (dataValidator.isValidLine(line)) {
                Optional<Triangle> newTriangle = triangleCreator.createObject(line);
                if (newTriangle.isPresent()) {
                    triangleList.add(newTriangle.get());
                    LOGGER.info("Triangle is created. Vertex coordinates is  " + line);
                }
                else {
                    LOGGER.warn("Triangle not created. Points are in the same line: " + line);
                    throw new HandledException("Not a valid triangle: " + line);
                }
            }
            else {
                LOGGER.warn("Triangle not created. Not a valid data in line: " + line);
                throw new HandledException("Not a valid data in line: " + line);
            }
        }

        return triangleList;
    }

}
