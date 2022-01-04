package com.epam.geometry.entity;

import java.util.Objects;

public class Sides {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public Sides(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

}
