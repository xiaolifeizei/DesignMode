package com.matrix.builder.one;

/**
 * A类Subject建造者
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:57
 */
public class SubjectCategoryOneBuilder extends SubjectBuilder{

    @Override
    public void buildCategoryName() {
        subject.setCategoryName("CategoryOne");
    }
}
