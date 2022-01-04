package com.epam.geometry;

public class Parameters {

    private final double area;
    private final double perimeter;

    public Parameters(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
