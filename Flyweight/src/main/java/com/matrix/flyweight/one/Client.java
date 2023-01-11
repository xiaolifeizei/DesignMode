package com.matrix.flyweight.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:06
 */
public class Client {

    public static void main(String[] args) {
        Flyweight one = FlyweightFactory.get("one");
        Flyweight two = FlyweightFactory.get("two");
        Flyweight one1 = FlyweightFactory.get("one");

        System.out.println(one == two);
        System.out.println(one == one1);
    }
}
