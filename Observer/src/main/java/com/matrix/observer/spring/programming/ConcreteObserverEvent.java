package com.matrix.observer.spring.programming;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:42
 */
public class ConcreteObserverEvent extends ApplicationEvent {

    public ConcreteObserverEvent(Object source) {
        super(source);
    }
}
