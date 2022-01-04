package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;
import com.epam.geometry.core.Calculator;


public class AreaRangeSpecification implements Specification{

    private final double areaMin;
    private final double areaMax;
    private final static double ACCURACY = 0.0000001;

    private final Calculator calculator;

    public AreaRangeSpecification(double areaMin, double areaMax, Calculator calculator) {
        this.areaMin = areaMin;
        this.areaMax = areaMax;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(TriangleIdentifiable triangle) {
        double area = calculator.calculateArea(triangle);

        return (area-areaMin)>=0 && (areaMax-area)>=0;
    }
}
