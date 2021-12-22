package com.epam.geometry.entity;

import java.util.Objects;

public class Triangle {
    private Point firstVertex;
    private Point secondVertex;
    private Point thirdVertex;

    public Triangle(Point firstVertex, Point secondVertex, Point thirdVertex) {
        this.firstVertex  = firstVertex;
        this.secondVertex = secondVertex;
        this.thirdVertex  = thirdVertex;
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

    public void setFirstVertex(Point firstVertex) {
        this.firstVertex = firstVertex;
    }

    public void setSecondVertex(Point secondVertex) {
        this.secondVertex = secondVertex;
    }

    public void setThirdVertex(Point thirdVertex) {
        this.thirdVertex = thirdVertex;
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

    @Override
    public int hashCode() {
        int result = getFirstVertex().hashCode() + getSecondVertex().hashCode();
        result = 31*result + getThirdVertex().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "firstVertex=" + firstVertex +
                ", secondVertex=" + secondVertex +
                ", thirdVertex=" + thirdVertex +
                '}';
    }
}
