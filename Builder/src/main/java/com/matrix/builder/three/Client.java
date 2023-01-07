package com.matrix.builder.three;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 10:23
 */
public class Client {

    public static void main(String[] args) {
        Subject subjectOne = new Subject.SubjectOneBuilder()
                .setPartOne("aaa")
                .setPartTwo(1001L)
                .build();

        subjectOne.show();

        Subject subjectTwo = new Subject.SubjectTwoBuilder()
                .setPartOne("bbb")
                .setPartTwo(2002L)
                .build();

        subjectTwo.show();
    }
}
