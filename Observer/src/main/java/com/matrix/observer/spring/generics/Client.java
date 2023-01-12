package com.matrix.observer.spring.generics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 泛型化事件
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:49
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.publishEvent(new ConcreteObserverStringEvent("sysywjelws"));
        context.publishEvent(new ConcreteObserverLongEvent(3141592653L));
    }
}
