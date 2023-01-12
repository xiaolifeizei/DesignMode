package com.matrix.observer.spring.generics;

import org.springframework.context.ApplicationEvent;

/**
 * 事件抽象类
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:42
 */
public abstract class ConcreteObserverEvent<T> extends ApplicationEvent {

    public ConcreteObserverEvent(T source) {
        super(source);
    }
}
