package com.matrix.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:24
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("状态改变了：" + arg + " -> " + ((ConcreteSubject) o).getState());
    }
}
