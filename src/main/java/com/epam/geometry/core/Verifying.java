package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Verifying {

    private Double firstSide;
    private Double secondSide;
    private Double thirdSide;

    public final int ACCURACY = 4;

    public boolean isTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        return  !((thirdPoint.getX() - firstPoint.getX())/(secondPoint.getX() - firstPoint.getX()) ==
                ((thirdPoint.getY()- firstPoint.getY())/(secondPoint.getY()- firstPoint.getY())));
    }

    public boolean isEquilateralTriangle(Triangle triangle) {
        calculateSideLengths(triangle);

        return isEqual(firstSide,secondSide)&&isEqual(firstSide,thirdSide);
    }

    public boolean isIsoscelesTriangle(Triangle triangle) {
        calculateSideLengths(triangle);

        return (isEqual(firstSide,secondSide) || isEqual(firstSide,thirdSide) || isEqual(secondSide,thirdSide));
    }

    public boolean isObtuseTriangle(Triangle triangle) {
        calculateSideLengths(triangle);
        Double[] sideLengths = {firstSide, secondSide, thirdSide};
        Arrays.sort(sideLengths);

        return Math.pow(sideLengths[2],2)>Math.pow(sideLengths[1],2)+Math.pow(sideLengths[0],2);
    }

    private void calculateSideLengths(Triangle triangle) {

        Point firstVertex  = triangle.getFirstVertex();
        Point secondVertex = triangle.getSecondVertex();
        Point thirdVertex  = triangle.getThirdVertex();

        firstSide = Math.sqrt(Math.abs(Math.pow(firstVertex.getX()-secondVertex.getX(),2)
                + Math.pow(firstVertex.getY()-secondVertex.getY(),2)));
        secondSide = Math.sqrt(Math.abs(Math.pow(secondVertex.getX()-thirdVertex.getX(),2)
                + Math.pow(secondVertex.getY()-thirdVertex.getY(),2)));
        thirdSide = Math.sqrt(Math.abs(Math.pow(thirdVertex.getX()-firstVertex.getX(),2)
                + Math.pow(thirdVertex.getY()-firstVertex.getY(),2)));
    }

    private BigDecimal round(Double value) {
        MathContext context = new MathContext(ACCURACY, RoundingMode.HALF_UP);

        return new BigDecimal(value, context);
    }

    private boolean isEqual(Double firstValue, Double secondValue) {
        BigDecimal firstBigDecValue = round(firstValue);
        BigDecimal secondBigDecValue = round(secondValue);

        return firstBigDecValue.compareTo(secondBigDecValue) == 0;
    }
}
