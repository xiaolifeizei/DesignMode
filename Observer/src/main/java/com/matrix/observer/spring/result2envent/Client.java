package com.matrix.observer.spring.result2envent;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Spring 监听器返回结果做为事件进行发布
 * 1、监听器返回值是ApplicationEvent对象时会自动发布该事件
 * 2、监听器返回值是ApplicationEvent集合时会逐条发布集合里的事件
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:49
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.publishEvent(new ConcreteObserverEventOne<String>("test"));
    }
}
