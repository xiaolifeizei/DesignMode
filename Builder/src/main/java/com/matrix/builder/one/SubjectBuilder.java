package com.matrix.builder.one;

/**
 * 建造者基类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:47
 */
public abstract class SubjectBuilder {


    protected final Subject subject = new Subject();

    public abstract void buildCategoryName();

    /**
     * 这种方式每个builder只能创建一个subject
     */
    public Subject getSubject() {
        return subject;
    }
}
