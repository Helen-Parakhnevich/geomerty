package com.epam.geometry.repository;

import com.epam.geometry.TriangleIdentifiable;
import com.epam.geometry.entity.Triangle;

import java.util.*;

public class TriangleRepositoryImpl implements TriangleRepository {

    private Map<Integer, TriangleIdentifiable> store = new HashMap<>();

    public TriangleRepositoryImpl() {
    }

    public void add(TriangleIdentifiable triangle) {
        Integer triangleID = triangle.getId();
        store.put(triangleID, triangle);
    }

    @Override
    public void delete(TriangleIdentifiable triangle) {
        Integer triangleID = triangle.getId();
        store.remove(triangleID, triangle);
    }

    @Override
    public void update(TriangleIdentifiable triangle) {
        Integer triangleID = triangle.getId();
        store.put(triangleID, triangle);
    }

    @Override
    public List<TriangleIdentifiable> query(Specification specification) {
        List<TriangleIdentifiable> triangles = new ArrayList<>();
        for (TriangleIdentifiable triangle: store.values()) {
            if (specification.specified(triangle)) {
                triangles.add(triangle);
            }
        }
        return triangles;
    }

    @Override
    public List<TriangleIdentifiable> sort(Comparator<TriangleIdentifiable> comparator) {
        List<TriangleIdentifiable> result = new ArrayList<>(store.values());
        result.sort(comparator);
        return result;
    }
}
