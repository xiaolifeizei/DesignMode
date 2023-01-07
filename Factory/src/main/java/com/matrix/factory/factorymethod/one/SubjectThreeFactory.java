package com.matrix.factory.factorymethod.one;

/**
 * 第二种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class SubjectThreeFactory extends SubjectFactory {
    @Override
    public Subject getSubject() {
        super.beforeCreate();
        SubjectThreeImpl subjectThree = new SubjectThreeImpl();
        super.afterCreate();
        return subjectThree;
    }
}
