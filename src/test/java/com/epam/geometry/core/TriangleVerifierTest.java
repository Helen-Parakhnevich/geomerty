package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TriangleVerifierTest {

    private final static TriangleVerifier verifying = new TriangleVerifier();

    @Test
    public void testIsTriangleWhenPointsNotOneLine() {
        //given
        Point firstPoint  = new Point(2.1,3.3);
        Point secondPoint = new Point(1.1,4.3);
        Point thirdPoint  = new Point(5.1,2.3);

        //when
        boolean result = verifying.isTriangle(firstPoint, secondPoint, thirdPoint);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsTriangleWhenPointsOneLine() {
        //given
        Point firstPoint  = new Point(1,2);
        Point secondPoint = new Point(3,4);
        Point thirdPoint  = new Point(5,6);

        //when
        boolean result = verifying.isTriangle(firstPoint, secondPoint, thirdPoint);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsEquilateralTriangleWhenSidesNotEqual() {
        //given
        TriangleVerifier verifying = new TriangleVerifier();
        Triangle triangle = new Triangle(new Point(1,2), new Point(-1,-2), new Point(1,-2));

        //when
        boolean result = verifying.isEquilateralTriangle(triangle);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsEquilateralTriangleWhenSidesEqual() {
        //given
        Triangle triangle = new Triangle(new Point(-2,0), new Point(4,0), new Point(1,5.1962));

        //when
        boolean result = verifying.isEquilateralTriangle(triangle);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testisIsoscelesTriangleWhenTwoSidesEqual() {
        //given
        Triangle triangle = new Triangle(new Point(1,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isIsoscelesTriangle(triangle);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testisIsoscelesTriangleWhenTwoSidesNotEqual() {
        //given
        Triangle triangle = new Triangle(new Point(-1,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isIsoscelesTriangle(triangle);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testisIsObtuseTriangleWhenObtuseAngle() {
        //given
        Triangle triangle = new Triangle(new Point(-2,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isObtuseTriangle(triangle);

        //then
       Assert.assertTrue(result);
    }

    @Test
    public void testisIsObtuseTriangleWhenAllAcuteAngle() {
        //given
        Triangle triangle = new Triangle(new Point(1,2), new Point(2,3), new Point(3,2));

        //when
        boolean result = verifying.isObtuseTriangle(triangle);

        //then
        Assert.assertFalse(result);
    }
}
