package com.matrix.dm.stat.inherit;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:39
 */
public class Client {

    public static void main(String[] args) {
        SubjectProxy proxy = new SubjectProxy();
        proxy.request();
        proxy.response();
    }
}
