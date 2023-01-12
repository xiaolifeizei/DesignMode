package com.matrix.observer.spring.arbitrary;

import com.matrix.observer.spring.generics.ConcreteObserverLongEvent;
import com.matrix.observer.spring.generics.ConcreteObserverStringEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 事件发布任意对象
 *
 * @author : cui_feng
 * @since : 2023-01-12 11:49
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.publishEvent(new Arbitrary("我是一个任意类型的对象"));
    }
}
