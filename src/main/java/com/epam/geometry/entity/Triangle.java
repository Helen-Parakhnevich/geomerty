package com.epam.geometry.entity;

public class Triangle {
    private Point firstVertex;
    private Point secondVertex;
    private Point thirdVertex;

    public void Triangle(Point firstVertex, Point secondVertex, Point thirdVertex) {
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

    public Point[] getArrayVerteces() {
        Point[] arrayVerteces = new Point[3];

        arrayVerteces[0] = getFirstVertex();
        arrayVerteces[1] = getSecondVertex();
        arrayVerteces[2] = getThirdVertex();

        return arrayVerteces;
    }
}
