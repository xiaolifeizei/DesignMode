package com.matrix.factory.function.two;

/**
 * 目标对象2
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:00
 */
public class SubjectTwoImpl implements Subject {
    @Override
    public void request() {
        System.out.println("SubjectTwo request....");
    }
}
