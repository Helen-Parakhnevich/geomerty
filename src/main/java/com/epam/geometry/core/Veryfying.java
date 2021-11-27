package com.epam.geometry.core;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

public class Veryfying {

    public static boolean isTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {

        if ((thirdPoint.getX() - firstPoint.getX()/(secondPoint.getX()) - firstPoint.getX()) ==
                ((thirdPoint.getY()- firstPoint.getY())/(secondPoint.getY())- firstPoint.getY())) {
            return false;
        }

        return true;
    }

    public static boolean isIsoscelesTriangle(Triangle objectTriangle) {

        return true;
    }

    public static boolean isObtuseTriangle(Triangle objectTriangle) {

        return true;
    }
}
