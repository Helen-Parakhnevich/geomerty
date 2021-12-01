package com.epam.geometry.entity;

import java.util.Objects;

public class Triangle {
    private final Point firstVertex;
    private final Point secondVertex;
    private final Point thirdVertex;

    public Triangle(Point firstVertex, Point secondVertex, Point thirdVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.thirdVertex = thirdVertex;
    }

    public Point getFirstVertex() {
        return firstVertex;
    }

    public Point getSecondVertex() {
        return secondVertex;
    }

    public Point getThirdVertex() {
        return thirdVertex;
    }

    public Point[] getArrayVertices() {
        Point[] arrayVertices = new Point[3];

        arrayVertices[0] = getFirstVertex();
        arrayVertices[1] = getSecondVertex();
        arrayVertices[2] = getThirdVertex();

        return arrayVertices;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) obj;
        return ((firstVertex == triangle.firstVertex || (firstVertex != null && firstVertex.equals(triangle.getFirstVertex())))
                && (secondVertex == triangle.secondVertex || (secondVertex != null && secondVertex.equals(triangle.getSecondVertex())))
                && (thirdVertex == triangle.thirdVertex || (thirdVertex != null && thirdVertex.equals(triangle.getThirdVertex())))
        );

    }

}
