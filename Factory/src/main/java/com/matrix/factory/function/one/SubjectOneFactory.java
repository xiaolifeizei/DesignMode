package com.matrix.factory.function.one;

/**
 * 第一种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class SubjectOneFactory extends SubjectFactory {

    @Override
    public Subject getSubject() {
        super.beforeCreate();
        SubjectOneImpl subjectOne = new SubjectOneImpl();
        super.afterCreate();
        return subjectOne;
    }
}
