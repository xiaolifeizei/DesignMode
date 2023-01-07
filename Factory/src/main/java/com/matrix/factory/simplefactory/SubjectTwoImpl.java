package com.matrix.factory.simplefactory;

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

    @Override
    public void response() {
        System.out.println("SubjectTwo response....");
    }
}
