package com.matrix.observer.spring.result2envent;

import com.sun.istack.internal.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 事件监听器，相当于ConcreteObserver
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:46
 */
@Component("result2EventOneListener")
public class ConcreteObserverEventOneListener {

    /**
     * 只接收ConcreteObserverEventOne<String> 事件
     */
    @Order(1)
    @EventListener(ConcreteObserverEventOne.class)
    public void onEventOneListenerFirst(ConcreteObserverEventOne<String> event) {
        System.out.println("EventOne第一监听器收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
    }

    @Order(2)
    @Async
    @EventListener(ConcreteObserverEventOne.class)
    public List<ConcreteObserverEventTwo> onEventOneListenerSecond(ConcreteObserverEventOne<String> event) {
        System.out.println("EventOne第二监听器收到通知：" + event.getTimestamp() + " -> " + event.getSource() + "，事件类型：" + event.getClass().getSimpleName());
        List<ConcreteObserverEventTwo> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            list.add(new ConcreteObserverEventTwo(event.getSource().toString() + i));
        }
        return list;
    }
}
