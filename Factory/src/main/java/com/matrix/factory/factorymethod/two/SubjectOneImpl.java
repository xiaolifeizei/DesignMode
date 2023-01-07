package com.matrix.factory.factorymethod.two;

/**
 * 目标对象1
 *
 * @author : cui_feng
 * @since : 2023-01-05 16:59
 */
public class SubjectOneImpl implements Subject {
    @Override
    public void request() {
        System.out.println("SubjectOne request....");
    }
}
