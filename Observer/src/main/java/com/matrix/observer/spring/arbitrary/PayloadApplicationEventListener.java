package com.matrix.observer.spring.arbitrary;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * PayloadApplicationEvent事件监听器
 *
 * @author : cui_feng
 * @since : 2023-01-12 13:39
 */
@Component
public class PayloadApplicationEventListener {

    @EventListener
    public void onPayloadApplicationEvent(PayloadApplicationEvent<Arbitrary> event) {
        System.out.println("监听器收到通知：" + event.getTimestamp() + " -> " + event.getPayload().getName() + "，事件类型：" + event.getClass().getSimpleName());

    }
}
