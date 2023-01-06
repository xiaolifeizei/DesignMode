package com.matrix.factory.function.two;

/**
 * 第一种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class SubjectOneFactory implements SubjectFactory {

    @Override
    public Subject getSubject() {
        System.out.println("SubjectOne prepare....");
        return new SubjectOneImpl();
    }
}
