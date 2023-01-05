package com.matrix.dm.stat.inherit;

/**
 * 代理类
 * 通过继承方式实现
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:38
 */
public class SubjectProxy extends Subject {

    @Override
    public void request() {
        System.out.println("before request....");
        super.request();
        System.out.println("after request....");
    }

    @Override
    public void response() {
        System.out.println("before response....");
        super.response();
        System.out.println("after response....");
    }
}
