package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sides;
import com.epam.geometry.entity.Triangle;

public class Calculator {

    public Calculator() {
    }

    public double calculateArea(Triangle triangle) {

        Point firstVertex = triangle.getFirstVertex();
        Point secondVertex = triangle.getSecondVertex();
        Point thirdVertex = triangle.getThirdVertex();

        Double xDistanceFirstSecondPoints = secondVertex.getX()-firstVertex.getX();
        Double yDistanceFirstThirdPoints = thirdVertex.getY()-firstVertex.getY();
        Double xDistanceFirstThirdPoints = thirdVertex.getX()-firstVertex.getX();
        Double yDistanceSecondThirdPoints = thirdVertex.getX()-firstVertex.getX();

        // formula 1/2*abs((x2-x1)*(y3-y1) - (x3-x1)(y2-y1))
        Double area = (Math.abs(xDistanceFirstSecondPoints * yDistanceFirstThirdPoints
                                - xDistanceFirstThirdPoints * yDistanceSecondThirdPoints))/2;

        return area;
    }

    public double calculatePerimeter(Triangle triangle) {
        double perimeter =0;

        Sides sides = calculateSides(triangle);
        double firstSide  = sides.getFirstSide();
        double secondSide = sides.getSecondSide();
        double thirdSide  = sides.getThirdSide();

        perimeter = firstSide + secondSide + thirdSide;

        return perimeter;
    }

    public Sides calculateSides(Triangle triangle) {

        Point firstVertex = triangle.getFirstVertex();
        Point secondVertex = triangle.getSecondVertex();
        Point thirdVertex = triangle.getThirdVertex();

        Double firstSide = calculateSideLength(firstVertex, secondVertex);
        Double secondSide = calculateSideLength(secondVertex, thirdVertex);
        Double thirdSide = calculateSideLength(thirdVertex, firstVertex);

        Sides sides = new Sides(firstSide, secondSide, thirdSide);
        return sides;
    }

    public Double calculateSideLength(Point startPoint, Point endPoint) {
        //formula sqrt((x2-x1)^2 + (y2-y1)^2)
        Double xDistance = endPoint.getX()-startPoint.getX();
        Double yDistance = endPoint.getY()-startPoint.getY();
        Double xDistanceSquared = Math.pow(xDistance,2);
        Double yDistanceSquared = Math.pow(yDistance,2);
        Double sideLength = Math.sqrt(xDistanceSquared + yDistanceSquared);
        return sideLength;
    }
}
