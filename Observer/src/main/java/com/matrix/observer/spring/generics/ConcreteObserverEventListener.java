package com.matrix.observer.spring.generics;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:46
 */
@Component("genericsEventListener")
public class ConcreteObserverEventListener {

    /**
     * 只接收ConcreteObserverEventOne<String> 事件
     */
    @Order(1)
    @EventListener(ConcreteObserverStringEvent.class)
    public void onEventStringListenerFirst(ConcreteObserverEvent<String> event) {
        System.out.println("StringEvent监听器收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }

    @Order(2)
    @EventListener(ConcreteObserverLongEvent.class)
    public void onEventLongListenerSecond(ConcreteObserverEvent<Long> event) {
        System.out.println("LongEvent  监听器收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }
}
