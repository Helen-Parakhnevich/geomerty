package com.epam.geometry;

import com.epam.geometry.core.Calculator;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class TriangleIdentifiableTest {

    private static Double DELTA = 0.001;

    @Test
    public void testObservers() {
        //given
        TriangleIdentifiable triangle = new TriangleIdentifiable(1, new Point(1,2), new Point(-1,-2), new Point(1,-2));
        TriangleStore store = TriangleStore.getInstance();
        triangle.attach(store);

        //when
        triangle.setFirstVertex(new Point(1,3));

        //then
        Map<Integer, Parameters> mapTriangles = store.getParameters();
        Parameters parameters = mapTriangles.get(1);
        Double newArea = parameters.getArea();
        Double newPerimeter = parameters.getPerimeter();

        Assert.assertEquals(5, newArea, DELTA);
        Assert.assertEquals(12.3851, newPerimeter, DELTA);
    }
}
