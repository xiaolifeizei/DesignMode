package com.matrix.observer.spring.programming;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 事件通知使用编程方式例子
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:49
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.publishEvent(new ConcreteObserverEvent("test"));
    }
}
