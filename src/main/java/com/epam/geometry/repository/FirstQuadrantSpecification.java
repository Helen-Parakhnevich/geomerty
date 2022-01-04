package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;
import com.epam.geometry.entity.Point;

public class FirstQuadrantSpecification implements Specification {

    @Override
    public boolean specified(TriangleIdentifiable triangle) {

        Point firstVertex = triangle.getFirstVertex();
        Point secondVertex = triangle.getSecondVertex();
        Point thirdVertex = triangle.getThirdVertex();

        return firstVertex.getX()>0 && firstVertex.getY()>0
                && secondVertex.getX()>0 && secondVertex.getY()>0
                && thirdVertex.getX()>0 && thirdVertex.getY()>0;
    }
}
