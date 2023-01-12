package com.matrix.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:07
 */
public abstract class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

    public abstract String getState();

    public abstract void change(String state);
}
