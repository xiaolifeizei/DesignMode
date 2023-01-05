package com.matrix.proxy.stat.compose;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:43
 */
public class Client {

    public static void main(String[] args) {
        SubjectProxy peopleProxy = new SubjectProxy(new SubjectImpl());
        peopleProxy.request();
        peopleProxy.response();
    }
}
