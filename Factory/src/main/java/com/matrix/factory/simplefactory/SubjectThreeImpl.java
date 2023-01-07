package com.matrix.factory.simplefactory;

/**
 * 目标对象3
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:01
 */
public class SubjectThreeImpl implements Subject {
    @Override
    public void request() {
        System.out.println("SubjectThree request....");
    }

    @Override
    public void response() {
        System.out.println("SubjectThree response....");
    }
}
