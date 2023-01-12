package com.matrix.observer.pull;

import lombok.Getter;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:15
 */
public class ConcreteObserver implements Observer{

    @Getter
    private String state = "";

    @Override
    public void update(Subject subject) {
        this.state = subject.getState();
        System.out.println("state is changed->" + this.state);
    }
}
