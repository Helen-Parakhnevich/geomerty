package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

public class Calculator {

    public double calculateArea(Triangle objectTriangle) {
        double area =0;

        Point[] verteces = objectTriangle.getArrayVertices();

        area = 1/2* (Math.abs((verteces[1].getX()-verteces[0].getX()*(verteces[2].getY()-verteces[0].getY()))
                                  -(verteces[2].getX()-verteces[0].getX())*(verteces[1].getY()-verteces[2].getY())));

        return area;
    }

    public double calculatePerimeter(Triangle objectTriangle) {
        double perimeter =0;

        double firstSideLength = calculateSideLengths(objectTriangle)[0];
        double secondSideLength = calculateSideLengths(objectTriangle)[1];
        double thirdSideLength = calculateSideLengths(objectTriangle)[2];

        perimeter = firstSideLength + secondSideLength + thirdSideLength;

        return perimeter;
    }

    private Double[] calculateSideLengths(Triangle objectTriangle) {
        Double[] sideLengths = new Double[3];

        Point[] verteces = objectTriangle.getArrayVertices();

        sideLengths[0] = Math.sqrt(Math.abs(Math.pow(verteces[0].getX()-verteces[1].getX(),2)
                                            + Math.pow(verteces[0].getY()-verteces[1].getY(),2)));
        sideLengths[1] = Math.sqrt(Math.abs(Math.pow(verteces[1].getX()-verteces[2].getX(),2)
                                            + Math.pow(verteces[1].getY()-verteces[2].getY(),2)));
        sideLengths[2] = Math.sqrt(Math.abs(Math.pow(verteces[2].getX()-verteces[0].getX(),2)
                                            + Math.pow(verteces[2].getY()-verteces[0].getY(),2)));
        return sideLengths;
    }
}
