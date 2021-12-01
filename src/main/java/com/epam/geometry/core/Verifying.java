package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.Arrays;

public class Verifying {

    public static boolean isTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {

        return  !((thirdPoint.getX() - firstPoint.getX()/(secondPoint.getX()) - firstPoint.getX()) ==
                ((thirdPoint.getY()- firstPoint.getY())/(secondPoint.getY())- firstPoint.getY()));
    }

    public boolean isEquailateralTriangle(Triangle triangle) {
        Double[] sideLengths = calculateSideLengths(triangle);

        return (sideLengths[0] == sideLengths[1]) && (sideLengths[0] == sideLengths[2]);
    }

    public boolean isIsoscelesTriangle(Triangle triangle) {
        Double[] sideLengths = calculateSideLengths(triangle);

        return (sideLengths[0] == sideLengths[1]) || (sideLengths[0] == sideLengths[2]) || (sideLengths[1] == sideLengths[2]);
    }

    public boolean isObtuseTriangle(Triangle triangle) {
        Double[] sideLengths = calculateSideLengths(triangle);
        Arrays.sort(sideLengths);

        return Math.pow(sideLengths[2],2)>Math.pow(sideLengths[1],2)+Math.pow(sideLengths[0],2);
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
