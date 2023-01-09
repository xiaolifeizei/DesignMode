package com.matrix.prototype.database;

/**
 * @author : cui_feng
 * @since : 2023-01-09 09:40
 */
public class Client {

    public static void main(String[] args) {
        SubjectCache.loadCache();

        Subject subjectOne1 = SubjectCache.getSubject("1");
        Subject subjectOne2 = SubjectCache.getSubject("1");
        System.out.println(subjectOne1 == subjectOne2);
        subjectOne1.show();
        subjectOne2.show();

        System.out.println("===================================================");

        Subject subjectTwo1 = SubjectCache.getSubject("2");
        Subject subjectTwo2 = SubjectCache.getSubject("2");
        System.out.println(subjectTwo1 == subjectTwo2);
        subjectTwo1.show();
        subjectTwo2.show();
    }
}
