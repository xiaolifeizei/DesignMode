package com.matrix.observer.spring.annotation;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:42
 */
public class ConcreteObserverEventOne extends ApplicationEvent {

    public ConcreteObserverEventOne(Object source) {
        super(source);
    }
}
