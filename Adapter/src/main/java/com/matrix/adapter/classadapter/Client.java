package com.matrix.adapter.classadapter;

/**
 * 使用
 * 适配器继承Adaptee类同时实现Target接口，这种方式无法对Adaptee的子类进行适配
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:42
 */
public class Client {
    private static void todo(Target target) {
        target.response();
    }

    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        todo(classAdapter);
    }
}
