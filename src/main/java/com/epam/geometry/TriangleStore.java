package com.epam.geometry;

import com.epam.geometry.core.Calculator;

import java.util.HashMap;
import java.util.Map;

public class TriangleStore implements Observer<TriangleObservable>{

    private static TriangleStore instance;

    private final Map<Integer, Parameters> parameters = new HashMap<>();

    private final Calculator calculator = new Calculator();

    private TriangleStore() {};

    public void update(TriangleObservable triangle) {
        System.out.print("Triangle has been changed");
        double area = calculator.calculateArea(triangle);
        System.out.print("new area = " + area);
        double perimeter = calculator.calculatePerimeter(triangle);
        parameters.put(triangle.getId(), new Parameters(area, perimeter));
    }

    public static TriangleStore getInstance() {
        if (instance == null) {
            instance = new TriangleStore();
        }
        return instance;
    }
}
