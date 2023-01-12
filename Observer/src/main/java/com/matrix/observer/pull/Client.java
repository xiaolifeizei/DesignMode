package com.matrix.observer.pull;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:18
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();

        subject.attach(observer);
        subject.change("work");
    }
}
