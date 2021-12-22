package com.epam.geometry;

import com.epam.geometry.core.Calculator;
import com.epam.geometry.service.HandledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TriangleStore implements Observer<TriangleIdentifiable>{

    private static TriangleStore instance;
    private final Logger LOGGER = LogManager.getLogger(HandledException.class);

    private final Map<Integer, Parameters> parameters = new HashMap<>();

    private final Calculator calculator = new Calculator();

    public Map<Integer, Parameters> getParameters() {
        return parameters;
    }

    public void update(TriangleIdentifiable triangle) {
        double area = calculator.calculateArea(triangle);
        double perimeter = calculator.calculatePerimeter(triangle);
        parameters.put(triangle.getId(), new Parameters(area, perimeter));
        LOGGER.warn("Triangle has been changed! new area = " + area + "; new perimeter = " + perimeter);
    }

    public static TriangleStore getInstance() {
        if (instance == null) {
            instance = new TriangleStore();
        }
        return instance;
    }
}
