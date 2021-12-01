package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class VerifyingTest {
    private static final Logger LOGGER = LogManager.getLogger(VerifyingTest.class);

    @Test
    public void testIsTriangle() {
        //given
        Point firstPoint  = new Point(2.1,3.3);
        Point secondPoint = new Point(1.1,4.3);
        Point thirdPoint  = new Point(5.1,2.3);
        //when

        boolean result = Verifying.isTriangle(firstPoint, secondPoint, thirdPoint);

        LOGGER.warn("Test verifying done");
        //then
        Assert.assertEquals(true, result);
    }

}
