package com.epam.geometry;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleIdentifiable extends Triangle implements Observable<TriangleIdentifiable> {

    private final Integer id;
    private final List<Observer<TriangleIdentifiable>> observers = new ArrayList<>();

    public TriangleIdentifiable(int id, Point firstVertex, Point secondVertex, Point thirdVertex) {
        super(firstVertex, secondVertex, thirdVertex);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setFirstVertex(Point firstVertex) {
        super.setFirstVertex(firstVertex);
        notifyObservers();
    }

    @Override
    public void attach(Observer<TriangleIdentifiable> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<TriangleIdentifiable> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<TriangleIdentifiable> observer : observers) {
            observer.update(this);
        }
    }
}
