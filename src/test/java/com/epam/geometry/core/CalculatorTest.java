package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sides;
import com.epam.geometry.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final static Double DELTA = 0.001;

    @Test
    public void testCalculateArea() {
        //given
        Triangle triangle = new Triangle(new Point(1,2), new Point(-1,-2), new Point(1,-2));

        //when
        double result = calculator.calculateArea(triangle);

        //then
        Assert.assertEquals(4, result, DELTA);
    }

    @Test
    public void testCalculatePerimeter() {
        //given
        Triangle triangle = new Triangle(new Point(1.1,2.2), new Point(3.3,4.4), new Point(5.5,6.6));

        //when
        double result = calculator.calculatePerimeter(triangle);

        //then
       Assert.assertEquals(12.4451, result, DELTA);
    }

    @Test
    public void testCalculateSides() {
        //given
        Triangle triangle = new Triangle(new Point(-0.866,-0.5), new Point(0.866,-0.5), new Point(0,1));
        Sides expectedSides = new Sides(1.732,1.7320381058163818,1.7320381058163818);

        //when
        Sides result = calculator.calculateSides(triangle);

        //then
        Assert.assertEquals(expectedSides, result);
    }

    @Test
    public void testCalculateSideLength() {
        //given
        Point firstPoint = new Point(1,1);
        Point secondPoint = new Point(1,3);

        //when
        double result = calculator.calculateSideLength(firstPoint, secondPoint);

        //then
        Assert.assertEquals(2, result, DELTA);
    }

}
