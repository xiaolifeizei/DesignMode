package com.matrix.observer.spring.resolvable;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * @author : cui_feng
 * @since : 2023-01-12 13:30
 */
public class ConcreteObserverResolvableEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

    public ConcreteObserverResolvableEvent(T source) {
        super(source);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
    }
}
