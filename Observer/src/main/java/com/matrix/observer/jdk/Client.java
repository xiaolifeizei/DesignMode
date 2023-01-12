package com.matrix.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:30
 */
public class Client {

    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();
        ConcreteSubject observable = new ConcreteSubject();

        observable.addObserver(observer);
        observable.change("work");
        System.out.println(observable.hasChanged());
    }
}
