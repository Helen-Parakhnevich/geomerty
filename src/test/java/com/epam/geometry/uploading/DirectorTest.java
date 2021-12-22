package com.epam.geometry.uploading;

import com.epam.geometry.core.Verifying;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import com.epam.geometry.service.HandledException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class DirectorTest {

    private  final static String PATH = "test";
    private  final static String VALID_COORDINATE = "(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)";
    private  final static String INVALID_COORDINATE = "(1.0;2.0) (3.0;4.0) (5.0;6.0)";
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
    public void testReadShouldCreateWhenDataValid() throws HandledException {
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

    @Test(expected = HandledException.class)
    public void testReadShouldCreateWhenInvalidLine() throws HandledException {
        //given
        DataReader reader  = Mockito.mock(DataReader.class);
        when(reader.readFile(PATH)).thenReturn(Arrays.asList(INVALID_COORDINATE));

        DataValidator validator = Mockito.mock(DataValidator.class);
        when(validator.isValidLine(anyString())).thenReturn(true);

        Verifying verifying = Mockito.mock(Verifying.class);
        when(verifying.isTriangle(any(Point.class), any(Point.class), any(Point.class))).thenReturn(false);

        TriangleCreator creator = Mockito.mock(TriangleCreator.class);
        when(creator.createObject(INVALID_COORDINATE)).thenReturn(Optional.empty());

        Director director = new Director(reader, validator, creator);

        //when
        List<Triangle> triangles = director.read(PATH);

        //then
        Assert.assertEquals(0, triangles.size());
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


    public static class DataReaderTest {

        @Test
        public void testReadFileWhenFileExists() throws HandledException {
            //given
            DataReader dataReader = new DataReader();
            String path = "/Users/Helen/Documents/JAVA/projects/geomerty/src/test/resources/coordinates.txt";
            List<String> dataList = Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)");

            //when
            List<String> result = dataReader.readFile(path);

            //then
            assertEquals(dataList, result);
        }

        @Test(expected = HandledException.class)
        public void testReadFileWhenFileNotExists() throws HandledException {
            //given
            DataReader dataReader = new DataReader();
            String path = "/Users/Helen/Documents/JAVA/projects/geomerty/src/test/resources/coord.txt";
            List<String> dataList = Arrays.asList("(1.1;2.1) (-1.1;-2.2) (1.2;-2.1)", "(-2.5,0.0) (4.1,0.5) (1.1,5.1962)");

            //when
            List<String> result = dataReader.readFile(path);

            //then
            assertEquals(dataList, result);
        }
    }
}