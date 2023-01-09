package com.matrix.bridge;

/**
 * 接口实现类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:58
 */
public class ConcreteImplementorSecond implements Implementor {

    @Override
    public void request() {
        System.out.println("the second request....");
    }

    @Override
    public void response() {
        System.out.println("the second response....");
    }
}
