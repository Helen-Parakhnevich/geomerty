package com.epam.geometry.core.uploading;

import com.epam.geometry.core.Verifying;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import com.epam.geometry.uploading.DataValidator;
import com.epam.geometry.uploading.TriangleCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TriangleCreatorTest {

    @Test
    public void testCreateObject() throws HandledException {
        //given
        TriangleCreator triangleCreator = new TriangleCreator(new Verifying());
        String line = "(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)";
        Optional<Triangle> triangle = Optional.of(new Triangle(new Point(-2.5,0.0), new Point(4.1,0.5), new Point(1.1,5.1962)));

        //when
        Optional<Triangle> result = triangleCreator.createObject(line);

        //then
        Assert.assertEquals(triangle, result);
    }
}
