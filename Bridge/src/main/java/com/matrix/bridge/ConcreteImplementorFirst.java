package com.matrix.bridge;

/**
 * 接口实现类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:58
 */
public class ConcreteImplementorFirst implements Implementor {

    @Override
    public void request() {
        System.out.println("the first request....");
    }

    @Override
    public void response() {
        System.out.println("the first response....");
    }
}
