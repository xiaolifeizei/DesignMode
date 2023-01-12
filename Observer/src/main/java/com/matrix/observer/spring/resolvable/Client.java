package com.matrix.observer.spring.resolvable;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 泛型化事件 使用ResolvableTypeProvider
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:49
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.publishEvent(new ConcreteObserverResolvableEvent<String>("sysywjelws"));
        context.publishEvent(new ConcreteObserverResolvableEvent<Long>(3141592653L));
    }
}
