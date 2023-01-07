package com.matrix.factory.simplefactory;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:05
 */
public class Client {

    static void doRequest(String type) {
        Subject subject = SubjectFactory.createSubject(type);
        if (subject != null) {
            subject.request();
        } else {
            System.out.println("创建Subject失败");
        }
    }

    static void doResponse(String type) {
        Subject subject = SubjectFactory.createSubject(type);
        if (subject != null) {
            subject.response();
        } else {
            System.out.println("创建Subject失败");
        }
    }

    public static void main(String[] args) {
        doRequest("one");
        doRequest("two");
        doRequest("three");

        doResponse("one");
        doResponse("two");
        doResponse("three");
    }
}
