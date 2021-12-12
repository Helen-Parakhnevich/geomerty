package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

public class Calculator {

    public Calculator() {
    }

    public double calculateArea(Triangle triangle) {
        double area =0;

        Point firstVertex = triangle.getFirstVertex();
        Point secondVertex = triangle.getSecondVertex();
        Point thirdVertex = triangle.getThirdVertex();

        area = (Math.abs(((secondVertex.getX()-firstVertex.getX())*(thirdVertex.getY()-firstVertex.getY()))
                                  -((thirdVertex.getX()-firstVertex.getX())*(secondVertex.getY()-thirdVertex.getY()))))/2;

        return area;
    }

    public double calculatePerimeter(Triangle triangle) {
        double perimeter =0;

        Double[] sideLengths = calculateSideLengths(triangle);
        double firstSideLength  = sideLengths[0];
        double secondSideLength = sideLengths[1];
        double thirdSideLength  = sideLengths[2];

        perimeter = firstSideLength + secondSideLength + thirdSideLength;

        return perimeter;
    }

    private Double[] calculateSideLengths(Triangle triangle) {
        Double[] sideLengths = new Double[3];

        Point firstVertex = triangle.getFirstVertex();
        Point secondVertex = triangle.getSecondVertex();
        Point thirdVertex = triangle.getThirdVertex();

        sideLengths[0] = Math.sqrt(Math.abs(Math.pow(firstVertex.getX()-secondVertex.getX(),2)
                                            + Math.pow(firstVertex.getY()-secondVertex.getY(),2)));
        sideLengths[1] = Math.sqrt(Math.abs(Math.pow(secondVertex.getX()-thirdVertex.getX(),2)
                                            + Math.pow(secondVertex.getY()-thirdVertex.getY(),2)));
        sideLengths[2] = Math.sqrt(Math.abs(Math.pow(thirdVertex.getX()-firstVertex.getX(),2)
                                            + Math.pow(thirdVertex.getY()-firstVertex.getY(),2)));
        return sideLengths;
    }
}
