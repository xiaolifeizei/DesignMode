package com.matrix.observer.pull;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:12
 */
public class ConcreteSubject extends Subject{

    private String state = "init";

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void change(String state) {
        this.state = state;
        super.notifyObservers();
    }
}
