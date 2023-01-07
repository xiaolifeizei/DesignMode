package com.matrix.factory.factorymethod.one;

/**
 * 第二种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class SubjectTwoFactory extends SubjectFactory {
    @Override
    public Subject getSubject() {
        super.beforeCreate();
        SubjectTwoImpl subjectTwo = new SubjectTwoImpl();
        super.afterCreate();
        return subjectTwo;
    }
}
