package com.epam.geometry.uploading;

import com.epam.geometry.core.TriangleVerifier;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class TriangleCreator {

    private final Logger LOGGER = LogManager.getLogger(TriangleCreator.class);

    private final static String DELEMITER_POINTS = " ";
    private final static String DELEMITER_COORDINATE = ";";
    private final static String REGEX_POINTS = "^\\(|\\)$";
    private final TriangleVerifier verifying;

    public TriangleCreator(TriangleVerifier verifying) {
        this.verifying = verifying;
    }


    public Optional<Triangle> createObject(String line) {
        Point[] arrayVertices = parseLine(line);
        Point firstVertex  = arrayVertices[0];
        Point secondVertex = arrayVertices[1];
        Point thirdVertex  = arrayVertices[2];
        if (verifying.isTriangle(firstVertex, secondVertex, thirdVertex)) {
            Triangle triangle = new Triangle(firstVertex, secondVertex, thirdVertex);
            LOGGER.info("Triangle created whit vertex coordinates: ("+firstVertex.getX()+";"+firstVertex.getY()+") ("
                                                                           +secondVertex.getX()+";"+secondVertex.getY()+") ("
                                                                           +thirdVertex.getX()+";"+thirdVertex.getY()+")");
            return Optional.of(triangle);
        }
        else {
            LOGGER.warn("Wrong vertex coordinates for a triangle: ("+firstVertex.getX()+";"+firstVertex.getY()+") ("
                                                                    +secondVertex.getX()+";"+secondVertex.getY()+") ("
                                                                    +thirdVertex.getX()+";"+thirdVertex.getY()+")");
            return Optional.empty();
        }
    }

    private Point[] parseLine(String line) {
        String[] arrayStrings = line.split(DELEMITER_POINTS);
        Point[] arrayVertices = new Point[3];
        for (int i=0; i<arrayStrings.length; i++) {
            String stringPoint = arrayStrings[i].replaceAll(REGEX_POINTS, "");
            stringPoint = stringPoint.replaceAll("\\s+", "");
            String[] coordinates = stringPoint.split(DELEMITER_COORDINATE);
            double coordinateX = Double.parseDouble(coordinates[0]);
            double coordinateY = Double.parseDouble(coordinates[1]);
            arrayVertices[i] = new Point(coordinateX, coordinateY);
        }

        return arrayVertices;
    }
}
