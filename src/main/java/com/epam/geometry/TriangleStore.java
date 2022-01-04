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

    private final Calculator calculator;

    public Map<Integer, Parameters> getParameters() {
        return parameters;
    }

    private TriangleStore(Calculator calculator) {
        this.calculator = calculator;
    }

    public void update(TriangleIdentifiable triangle) {
        double area = calculator.calculateArea(triangle);
        double perimeter = calculator.calculatePerimeter(triangle);
        parameters.put(triangle.getId(), new Parameters(area, perimeter));
        LOGGER.warn("Triangle has been changed! new area = " + area + "; new perimeter = " + perimeter);
    }

    // only for testing purposes
    public static TriangleStore getInstance(Calculator calculator) {
        if (instance == null) {
            instance = new TriangleStore(calculator);
        }
        return instance;
    }

    public static TriangleStore getInstance() {
        if (instance == null) {
            return TriangleStore.getInstance(new Calculator());
        }
        return instance;
    }
}
