package com.epam.geometry;

public interface Observer<T> {
    void update(T event);
}
