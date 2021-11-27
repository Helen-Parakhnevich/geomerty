package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static double calculateArea(Triangle objectTriangle) {
        double area =0;

        Point[] verteces = objectTriangle.getArrayVerteces();

        area = 1/2* (Math.abs((verteces[1].getX()-verteces[0].getX()*(verteces[2].getY()-verteces[0].getY()))
                                  -(verteces[2].getX()-verteces[0].getX())*(verteces[1].getY()-verteces[2].getY())));

        return area;
    }

    public static double calculatePerimeter(Triangle objectTriangle) {
        double perimeter =0;

        double firstSideLength = calculateSideLengths(objectTriangle)[0];
        double secondSideLength = calculateSideLengths(objectTriangle)[1];
        double thirdSideLength = calculateSideLengths(objectTriangle)[2];

        perimeter = firstSideLength + secondSideLength + thirdSideLength;

        return perimeter;
    }

    private static double[] calculateSideLengths(Triangle objectTriangle) {
        double[] sideLengths = new double[3];

        Point[] verteces = objectTriangle.getArrayVerteces();

        sideLengths[0] = Math.sqrt(Math.abs(Math.pow(verteces[0].getX()-verteces[1].getX(),2)
                                            + Math.pow(verteces[0].getY()-verteces[1].getY(),2)));
        sideLengths[1] = Math.sqrt(Math.abs(Math.pow(verteces[1].getX()-verteces[2].getX(),2)
                                            + Math.pow(verteces[1].getY()-verteces[2].getY(),2)));
        sideLengths[2] = Math.sqrt(Math.abs(Math.pow(verteces[2].getX()-verteces[0].getX(),2)
                                            + Math.pow(verteces[2].getY()-verteces[0].getY(),2)));
        return sideLengths;
    }
}
