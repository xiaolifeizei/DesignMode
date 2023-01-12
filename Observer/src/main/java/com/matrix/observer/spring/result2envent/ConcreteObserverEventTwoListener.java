package com.matrix.observer.spring.result2envent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器，相当于ConcreteObserver
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:46
 */
@Component("result2EventTwoListener")
public class ConcreteObserverEventTwoListener {

    /**
     * 如果发布的是ApplicationEvent集合会一条一条的接受到
     */
    @EventListener(ConcreteObserverEventTwo.class)
    public void onEventTwoListener(ConcreteObserverEventTwo event) {
        System.out.println("EventTwo收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }
}
