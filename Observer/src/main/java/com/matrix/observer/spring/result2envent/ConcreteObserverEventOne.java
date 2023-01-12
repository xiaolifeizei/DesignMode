package com.matrix.observer.spring.result2envent;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:42
 */
public class ConcreteObserverEventOne<T> extends ApplicationEvent {

    public ConcreteObserverEventOne(T source) {
        super(source);
    }
}
