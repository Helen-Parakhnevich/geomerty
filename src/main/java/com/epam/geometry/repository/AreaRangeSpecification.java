package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;
import com.epam.geometry.core.Calculator;


public class AreaRangeSpecification implements Specification{

    private final Integer areaMin;
    private final Integer areaMax;

    private final Calculator calculator;

    public AreaRangeSpecification(Integer areaMin, Integer areaMax, Calculator calculator) {

        this.areaMin = areaMin;
        this.areaMax = areaMax;
        this.calculator = calculator;

    }

    @Override
    public boolean specified(TriangleIdentifiable triangle) {

        Integer area = (int)calculator.calculateArea(triangle);

        return area>=areaMin && area<=areaMax;
    }
}
