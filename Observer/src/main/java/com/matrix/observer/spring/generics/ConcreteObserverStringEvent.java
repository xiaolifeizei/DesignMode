package com.matrix.observer.spring.generics;

/**
 * 事件
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:42
 */
public class ConcreteObserverStringEvent extends ConcreteObserverEvent<String> {

    public ConcreteObserverStringEvent(String source) {
        super(source);
    }
}
