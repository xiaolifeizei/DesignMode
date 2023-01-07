package com.matrix.builder.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 08:44
 */
public class Client {

    public static void main(String[] args) {
        SubjectBuilder subjectOneBuilder = new SubjectCategoryOneBuilder();
        SubjectBuilder subjectTwoBuilder = new SubjectCategoryTwoBuilder();

        SubjectDirector subjectDirector = new SubjectDirector(subjectOneBuilder);

        Subject subjectOne = subjectDirector.build();

        subjectDirector.setSubjectBuilder(subjectTwoBuilder);
        Subject subjectTwo = subjectDirector.build();

        subjectOne.request();
        subjectTwo.request();
    }
}
