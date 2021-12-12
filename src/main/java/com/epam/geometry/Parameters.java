package com.epam.geometry;

public class Parameters {

    private final double Area;
    private final double Perimeter;

    public Parameters(double area, double perimeter) {
        Area = area;
        Perimeter = perimeter;
    }

    public double getArea() {
        return Area;
    }

    public double getPerimeter() {
        return Perimeter;
    }
}
