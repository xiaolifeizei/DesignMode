package com.matrix.builder.one;

/**
 * Director，负责组装
 *
 * @author : cui_feng
 * @since : 2023-01-06 16:02
 */
public class SubjectDirector {

    private SubjectBuilder subjectBuilder;

    public SubjectDirector(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public void setSubjectBuilder(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public Subject build() {
        subjectBuilder.buildCategoryName();
        return subjectBuilder.getSubject();
    }
}
