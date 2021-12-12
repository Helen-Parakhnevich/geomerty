package com.epam.geometry.core.core;

import com.epam.geometry.core.Calculator;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculateArea() {
        //given
        Calculator calculator = new Calculator();
        Triangle triangle = new Triangle(new Point(1,2), new Point(-1,-2), new Point(1,-2));

        //when
        double result = calculator.calculateArea(triangle);

        //then
        Assert.assertEquals(4, result, 0.001);
    }

    @Test
    public void testCalculatePerimeter() {
        //given
        Calculator calculator = new Calculator();
        Triangle triangle = new Triangle(new Point(1.1,2.2), new Point(3.3,4.4), new Point(5.5,6.6));

        //when
        double result = calculator.calculatePerimeter(triangle);

        //then
       Assert.assertEquals(12.4451, result, 0.001);
    }
}
