package com.matrix.adapter.objectadapter;

/**
 * 使用
 * 适配器中持有Adaptee对象并实现Target接口，优先推荐这种方式
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:42
 */
public class Client {
    private static void todo(Target target) {
        target.response();
    }

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        ObjectAdapter objectAdapter = new ObjectAdapter(adaptee);
        todo(objectAdapter);
    }
}
