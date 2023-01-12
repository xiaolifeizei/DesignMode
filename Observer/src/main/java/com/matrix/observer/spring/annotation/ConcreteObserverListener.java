package com.matrix.observer.spring.annotation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器，相当于ConcreteObserver
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:46
 */
@Component("observerListener")
public class ConcreteObserverListener {

    /**
     * 相当于update方法
     */
    @EventListener({ConcreteObserverEventOne.class, ConcreteObserverEventTwo.class})
    public void onEventListener(ApplicationEvent event) {
        System.out.println("收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }
}
