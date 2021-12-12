package com.epam.geometry;

public interface Observer<T> {

    //void update(TriangleIdentifiable triangle);
    void update(T event);
}
