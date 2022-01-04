package com.epam.geometry.repository;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import org.junit.Test;

public class TriangleRepositoryImplTest {

    private static final Triangle FIRST_TRIANGLE = new Triangle(new Point(1.1,2.1),
                                                               new Point(-1.1,-2.2),
                                                               new Point(1.2,-2.1));
    private static final Triangle SECOND_TRIANGLE = new Triangle(new Point(-2.5,0.0),
                                                                new Point(4.1,0.5),
                                                                new Point(1.1,5.1962));


    @Test
    public void testQueryShouldReturnTriangleFirstQuadrantSpecification() {
        //given
        TriangleRepositoryImpl repository = new TriangleRepositoryImpl();

        //when

        //then

    }
}
