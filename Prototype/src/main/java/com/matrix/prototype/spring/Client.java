package com.matrix.prototype.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:21
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Subject subject1 = context.getBean("subject",Subject.class);
        Subject subject2 = context.getBean("subject",Subject.class);

        System.out.println(subject1 == subject2);
    }
}
