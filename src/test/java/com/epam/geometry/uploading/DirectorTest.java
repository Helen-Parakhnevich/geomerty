package com.epam.geometry.uploading;

import com.epam.geometry.core.Verifying;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class DirectorTest {

    private  final static String PATH = "test";
    private  final static String VALID_COORDINATE = "(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)";
    private Director sut;

//    @Mock
    private DataReader readerMock;

    @Before
    public void init() {
//        MockitoAnnotations.initMocks(this);
        readerMock = mock(DataReader.class);

        sut = new Director(readerMock, new DataValidator(), new TriangleCreator(new Verifying()));
    }

    @Test
    public void testReadShouldCreateWhenValid() throws HandledException {
        //given
        DataReader reader  = Mockito.mock(DataReader.class);
        when(reader.readFile(PATH)).thenReturn(Arrays.asList(VALID_COORDINATE));

        DataValidator validator = Mockito.mock(DataValidator.class);
        when(validator.isValidLine(anyString())).thenReturn(true);

        Verifying verifying = Mockito.mock(Verifying.class);
        when(verifying.isTriangle(any(Point.class), any(Point.class), any(Point.class))).thenReturn(true);

        TriangleCreator creator = Mockito.mock(TriangleCreator.class);
        Triangle triangle = new Triangle(new Point(1.1,2.1), new Point(-1.1,-2.2), new Point(1.2,-2.1));
        when(creator.createObject(VALID_COORDINATE)).thenReturn(Optional.of(triangle));

        Director director = new Director(reader, validator, creator);

        //when
        List<Triangle> triangles = director.read(PATH);

        //then
        Assert.assertEquals(1, triangles.size());
        Assert.assertEquals(triangles.get(0), triangle);
    }

    /*@Test
    public void shouldCalculateSmth() throws HandledException {
        //GIVEN
        List<String> mockedData = new ArrayList<>(Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)"));
//        doReturn(mockedData).when(readerMock).readFile(any());
        when(readerMock.readFile(any())).thenReturn(mockedData);

        //WHEN
        System.out.println(sut.read("fake.file"));
    }

    @Test
    public void shouldFailValidation() throws HandledException {
        //GIVEN
        List<String> mockedData = new ArrayList<>(Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)"));
//        doReturn(mockedData).when(readerMock).readFile(any());
        when(readerMock.readFile(any())).thenReturn(mockedData);

        //WHEN
        System.out.println(sut.read("fake.file"));


    }*/


}