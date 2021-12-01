package com.epam.geometry.upload;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

import java.util.List;

public class TriangleCreator {
    private final static String DELEMITER_POINTS = " ";
    private final static String DELEMITER_COORDINATE = ";";
    private final static String REGEX_POINTS = "^\\(|\\)$";

    public static Triangle createObject(String line) {
        Point[] arrayVertices = parseLine(line);
        Triangle newTriangle = new Triangle(arrayVertices[0], arrayVertices[1], arrayVertices[2]);
        return newTriangle;
    }

    private static Point[] parseLine(String line) {
        String[] arrayStrings = line.split(DELEMITER_POINTS);
        Point[] arrayVertices = new Point[3];
        for (int i=0; i<arrayStrings.length; i++) {
            arrayStrings[i] = arrayStrings[i].replaceAll(REGEX_POINTS, "");
            String[] coordinates = arrayStrings[i].split(DELEMITER_COORDINATE);
            double coordinateX = Double.parseDouble(coordinates[0]);
            double coordinateY = Double.parseDouble(coordinates[1]);
            arrayVertices[i] = new Point(coordinateX, coordinateY);
        }
        return arrayVertices;
    }
}
