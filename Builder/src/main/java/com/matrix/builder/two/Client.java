package com.matrix.builder.two;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 10:23
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject.SubjectBuilder()
                .setPartOne("aaa")
                .setPartTwo(1001L)
                .build();

        subject.show();
    }
}
