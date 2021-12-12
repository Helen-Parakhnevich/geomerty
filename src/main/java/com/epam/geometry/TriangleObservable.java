package com.epam.geometry;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleObservable extends Triangle implements Observable<TriangleObservable> {

    private final Integer id;
    private final List<Observer<TriangleObservable>> observers = new ArrayList<>();

    public TriangleObservable(int id, Point firstVertex, Point secondVertex, Point thirdVertex) {
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
    public void attach(Observer<TriangleObservable> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<TriangleObservable> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<TriangleObservable> observer : observers) {
            observer.update(this);
        }
    }
}
