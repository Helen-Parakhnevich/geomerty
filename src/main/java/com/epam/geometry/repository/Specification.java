package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;

public interface Specification {

    boolean specified(TriangleIdentifiable triangle);
}
