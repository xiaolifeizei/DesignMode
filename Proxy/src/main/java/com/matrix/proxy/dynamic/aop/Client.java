package com.matrix.proxy.dynamic.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-05 14:50
 */
public class Client {

    public static void main(String[] args) {
        System.out.println(Subject.class.isInterface());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // jdk动态代理必须使用接口调用
        Subject subject = (Subject) context.getBean("subjectImpl");
        System.out.println(subject.getClass().getName());
        subject.request();
        subject.response();

        System.out.println("-------------------------------------------------");

        SubjectNoInterface subjectNoInterface = context.getBean("subjectNoInterface", SubjectNoInterface.class);
        System.out.println(subjectNoInterface.getClass().getName());
        subjectNoInterface.request();
        subjectNoInterface.response();

    }
}
