package com.matrix.factory.factorymethod.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:42
 */
public class Client {

    public static void main(String[] args) {
        SubjectFactory subjectOneFactory = new SubjectOneFactory();
        Subject subjectOne = subjectOneFactory.getSubject();

        SubjectFactory subjectTwoFactory = new SubjectTwoFactory();
        Subject subjectTwo = subjectTwoFactory.getSubject();

        SubjectFactory subjectThreeFactory = new SubjectThreeFactory();
        Subject subjectThree = subjectThreeFactory.getSubject();

        subjectOne.request();
        subjectTwo.request();
        subjectThree.request();
    }
}
