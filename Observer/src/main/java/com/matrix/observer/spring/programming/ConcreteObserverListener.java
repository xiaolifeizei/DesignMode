package com.matrix.observer.spring.programming;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器，相当于ConcreteObserver
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:46
 */
@Component
public class ConcreteObserverListener implements ApplicationListener<ConcreteObserverEvent> {

    /**
     * 相当于update方法
     */
    @Override
    public void onApplicationEvent(ConcreteObserverEvent event) {
        System.out.println("收到通知：" + event.getTimestamp() + " -> " + event.getSource());
    }
}
