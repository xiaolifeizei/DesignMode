package com.matrix.builder.four;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 11:44
 */
public class Client {

    public static void main(String[] args) {
        SubjectBuilder subjectBuilderOne = new SubjectOneBuilder();
        SubjectBuilder subjectBuilderTwo = new SubjectTwoBuilder();

        SubjectDirector director = new SubjectDirector(subjectBuilderOne);
        Subject subjectOneFirst = director.buildSubjectOneFirst();
        Subject subjectOneSecond = director.buildSubjectOneSecond();

        director.setSubjectBuilder(subjectBuilderTwo);
        Subject subjectTwoFirst = director.buildSubjectTwoFirst();
        Subject subjectTwoSecond = director.buildSubjectTwoSecond();

        System.out.println("-----------------------------------");
        subjectOneFirst.show();
        System.out.println("-----------------------------------");
        subjectOneSecond.show();

        System.out.println("-----------------------------------");
        subjectTwoFirst.show();
        System.out.println("-----------------------------------");
        subjectTwoSecond.show();

    }
}
