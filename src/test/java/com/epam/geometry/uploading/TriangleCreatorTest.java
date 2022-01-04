package com.epam.geometry.uploading;

import com.epam.geometry.core.TriangleVerifier;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TriangleCreatorTest {

    private final static Double DELTA = 0.001;

    @Test
    public void testCreateObjectWhenValidData() throws HandledException {
        //given
        TriangleCreator triangleCreator = new TriangleCreator(new TriangleVerifier());
        String line = "(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)";
        Optional<Triangle> triangle = Optional.of(new Triangle(new Point(1.1,2.1), new Point(-1.1,-2.2), new Point(1.2,-2.1)));

        //when
        Optional<Triangle> result = triangleCreator.createObject(line);

        //then
        Assert.assertEquals(triangle, result);
    }

    @Test
    public void testCreateObjectWhenInvalidData() throws HandledException {
        //given
        TriangleCreator triangleCreator = new TriangleCreator(new TriangleVerifier());
        String line = "(1.0;2.0) (3.0;4.0) (5.0;6.0)";

        //when
        Optional<Triangle> result = triangleCreator.createObject(line);

        //then
        Assert.assertEquals(Optional.empty(), result);
    }
}
