package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sides;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.uploading.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TriangleVerifier {

    private final static double ACCURACY = 0.0000001;
    private final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public boolean isTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        // formula if (y3-y1)/(y2-y1)==(x3-x1)/(x2-x1) is false
        double xDistanceFirstThirdPoints = thirdPoint.getX() - firstPoint.getX();
        double yDistanceFirstThirdPoints = thirdPoint.getY()- firstPoint.getY();
        double xDistanceFirstSecondPoints = secondPoint.getX() - firstPoint.getX();
        double yDistanceFirstSecondPoints = secondPoint.getY()- firstPoint.getY();

        if (xDistanceFirstSecondPoints==0||yDistanceFirstSecondPoints==0) {
            String stringCoordinates = getStringCoordinates(firstPoint, secondPoint, thirdPoint);
            LOGGER.warn("Not correct coordinates: " + stringCoordinates);
            return  false;
        }
        else {
            double xRatio = xDistanceFirstThirdPoints/xDistanceFirstSecondPoints;
            double yRatio = yDistanceFirstThirdPoints/yDistanceFirstSecondPoints;

            return  !(isEqual(xRatio, yRatio));
        }
    }

    public boolean isEquilateralTriangle(Triangle triangle) {
        Sides sides = calculateTriangleSides(triangle);
        double firstSide = sides.getFirstSide();
        double secondSide = sides.getSecondSide();
        double thirdSide = sides.getThirdSide();

        return isEqual(firstSide,secondSide) && isEqual(firstSide,thirdSide);
    }

    public boolean isIsoscelesTriangle(Triangle triangle) {
        Sides sides = calculateTriangleSides(triangle);
        double firstSide = sides.getFirstSide();
        double secondSide = sides.getSecondSide();
        double thirdSide = sides.getThirdSide();

        return (isEqual(firstSide,secondSide) || isEqual(firstSide,thirdSide) || isEqual(secondSide,thirdSide));
    }

    public boolean isObtuseTriangle(Triangle triangle) {
        Sides sides = calculateTriangleSides(triangle);
        double firstSide = sides.getFirstSide();
        double secondSide = sides.getSecondSide();
        double thirdSide = sides.getThirdSide();
        double[] sideLengths = {firstSide, secondSide, thirdSide};
        Arrays.sort(sideLengths);
        double squareMaxSide = Math.pow(sideLengths[2],2);
        double squareSecondSide = Math.pow(sideLengths[1],2);
        double squareThirdSide = Math.pow(sideLengths[0],2);

        return squareMaxSide>squareSecondSide+squareThirdSide;
    }

    private Sides calculateTriangleSides(Triangle triangle) {
        Calculator calculator = new Calculator();
        return calculator.calculateSides(triangle);
    }

    private boolean isEqual(Double firstValue, Double secondValue) {
        return Math.abs(firstValue - secondValue) < ACCURACY;
    }

    private String getStringCoordinates(Point firstPoint, Point secondPoint, Point thirdPoint) {
        return "("+firstPoint.getX()+","+firstPoint.getY()+")"+" "
                +"("+secondPoint.getX()+","+secondPoint.getY()+")"+" "
                +"("+thirdPoint.getX()+","+thirdPoint.getY()+")"+" ";
    }
}
