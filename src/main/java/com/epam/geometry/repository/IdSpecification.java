package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;

public class IdSpecification implements Specification {

    private final Integer id;

    public IdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(TriangleIdentifiable triangle) {
        return triangle.getId().equals(id);
    }
}
