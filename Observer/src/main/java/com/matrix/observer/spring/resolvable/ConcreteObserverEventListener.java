package com.matrix.observer.spring.resolvable;

import com.matrix.observer.spring.generics.ConcreteObserverEvent;
import com.matrix.observer.spring.generics.ConcreteObserverLongEvent;
import com.matrix.observer.spring.generics.ConcreteObserverStringEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:46
 */
@Component("resolvableEventListener")
public class ConcreteObserverEventListener {

    @Order(1)
    @EventListener(ConcreteObserverResolvableEvent.class)
    public void onEventStringListenerFirst(ConcreteObserverResolvableEvent<String> event) {
        System.out.println("StringEvent监听器收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }

    @Order(2)
    @EventListener(ConcreteObserverLongEvent.class)
    public void onEventLongListenerSecond(ConcreteObserverResolvableEvent<Long> event) {
        System.out.println("LongEvent  监听器收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }
}
