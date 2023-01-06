package com.matrix.factory.function.two;

/**
 * 第二种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class SubjectTwoFactory implements SubjectFactory {
    @Override
    public Subject getSubject() {
        System.out.println("SubjectTwo prepare....");
        return new SubjectTwoImpl();
    }
}
