package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;

import java.util.Comparator;
import java.util.List;

public interface TriangleRepository {

    void add(TriangleIdentifiable triangle);
    void delete(TriangleIdentifiable triangle);
    void update(TriangleIdentifiable triangle);

    List<TriangleIdentifiable> query(Specification specification);
    List<TriangleIdentifiable> sort(Comparator<TriangleIdentifiable> comparator);
}
