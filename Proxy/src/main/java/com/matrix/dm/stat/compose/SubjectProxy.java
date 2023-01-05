package com.matrix.dm.stat.compose;

/**
 * 代理类
 * 通过组合方式实现
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:41
 */
public class SubjectProxy implements Subject {

    private final Subject target;

    public SubjectProxy(Subject target) {
        this.target = target;
    }

    @Override
    public void request() {
        System.out.println("before request....");
        target.request();
        System.out.println("after request....");
    }

    @Override
    public void response() {
        System.out.println("before response....");
        target.response();
        System.out.println("after response....");
    }
}
