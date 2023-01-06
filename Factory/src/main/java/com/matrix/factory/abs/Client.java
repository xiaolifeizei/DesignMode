package com.matrix.factory.abs;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-06 13:21
 */
public class Client {

    public static void main(String[] args) {
        SubjectFactory subjectCategoryAFactory = new SubjectCategoryAFactory();
        SubjectFirst subjectCategoryAFirstOne = subjectCategoryAFactory.getSubjectFirst("one");
        SubjectFirst subjectCategoryAFirstTwo = subjectCategoryAFactory.getSubjectFirst("two");

        SubjectFactory subjectCategoryBFactory = new SubjectCategoryBFactory();
        SubjectSecond subjectCategoryBSecondOne = subjectCategoryBFactory.getSubjectSecond("one");
        SubjectSecond subjectCategoryBSecondTwo = subjectCategoryBFactory.getSubjectSecond("two");

        subjectCategoryAFirstOne.request();
        subjectCategoryAFirstTwo.request();

        subjectCategoryBSecondOne.request();
        subjectCategoryBSecondTwo.request();

    }
}
