package com.matrix.observer.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 事件通知使用注解方式例子
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:49
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.publishEvent(new ConcreteObserverEventOne("test"));
        Thread.sleep(30L);
        context.publishEvent(new ConcreteObserverEventTwo("test2"));
    }
}
