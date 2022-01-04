package com.epam.geometry.uploading;

import com.epam.geometry.core.TriangleVerifier;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class DirectorTest {

    private  final static String PATH = "test";
    private  final static String VALID_COORDINATE = "(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)";
    private  final static String INVALID_COORDINATE = "(1.0;2.0) (3.0;4.0) (5.0;6.0)";
    private  final static String INVALID_LINE = "(1.1;2.1) ( -1.1 ;  -2.1 )";

    @Test
    public void testReadShouldCreateWhenDataValid() throws IOException, Exception {
        //given
        DataReader reader  = Mockito.mock(DataReader.class);
        when(reader.readFile(PATH)).thenReturn(Arrays.asList(VALID_COORDINATE));

        DataValidator validator = Mockito.mock(DataValidator.class);
        when(validator.isValidLine(anyString())).thenReturn(true);

        TriangleVerifier verifying = Mockito.mock(TriangleVerifier.class);
        when(verifying.isTriangle(any(Point.class), any(Point.class), any(Point.class))).thenReturn(true);

        TriangleCreator creator = Mockito.mock(TriangleCreator.class);
        Triangle triangle = new Triangle(new Point(1.1,2.1), new Point(-1.1,-2.2), new Point(1.2,-2.1));
        when(creator.createObject(VALID_COORDINATE)).thenReturn(Optional.of(triangle));

        Director director = new Director(reader, validator, creator);
        List<Triangle> triangles;

        //when
        try {
            triangles = director.read(PATH);
        } catch (HandledException e) {
            throw new Exception("Test failed. Check #isTriangle method");
        }

        //then
        Assert.assertEquals(1, triangles.size());
        Assert.assertEquals(triangles.get(0), triangle);
    }

    @Test(expected = HandledException.class)
    public void testReadShouldCreateWhenInvalidCoordinate() throws IOException, Exception {
        //given
        DataReader reader  = Mockito.mock(DataReader.class);
        when(reader.readFile(PATH)).thenReturn(Arrays.asList(INVALID_COORDINATE));

        DataValidator validator = Mockito.mock(DataValidator.class);
        when(validator.isValidLine(anyString())).thenReturn(true);

        TriangleVerifier verifying = Mockito.mock(TriangleVerifier.class);
        when(verifying.isTriangle(any(Point.class), any(Point.class), any(Point.class))).thenReturn(false);

        TriangleCreator creator = Mockito.mock(TriangleCreator.class);
        when(creator.createObject(INVALID_COORDINATE)).thenReturn(Optional.empty());

        Director director = new Director(reader, validator, creator);

        //when
        List<Triangle> triangles = director.read(PATH);

        //then
        Assert.assertEquals(0, triangles.size());
    }

    @Test(expected = HandledException.class)
    public void testReadShouldCreateWhenInvalidLine() throws IOException, Exception {
        //given
        DataReader reader  = Mockito.mock(DataReader.class);
        when(reader.readFile(PATH)).thenReturn(Arrays.asList(INVALID_LINE));

        DataValidator validator = Mockito.mock(DataValidator.class);
        when(validator.isValidLine(anyString())).thenReturn(false);

        TriangleVerifier verifying = Mockito.mock(TriangleVerifier.class);
        when(verifying.isTriangle(any(Point.class), any(Point.class), any(Point.class))).thenReturn(false);

        TriangleCreator creator = Mockito.mock(TriangleCreator.class);
        when(creator.createObject(INVALID_COORDINATE)).thenReturn(Optional.empty());

        Director director = new Director(reader, validator, creator);

        //when
        List<Triangle> triangles = director.read(PATH);

        //then
        Assert.assertEquals(0, triangles.size());
    }

}