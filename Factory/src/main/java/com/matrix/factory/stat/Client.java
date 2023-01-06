package com.matrix.factory.stat;

/**
 * 使用
 * 其实就是类加上静态方法，最常见，甚至不能算是设计模式
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:21
 */
public class Client {

    public static void main(String[] args) {
        SubjectFactory.request();
        SubjectFactory.response();
    }
}
