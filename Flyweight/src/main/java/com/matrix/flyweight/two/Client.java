package com.matrix.flyweight.two;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:19
 */
public class Client {

    public static void main(String[] args) {
        Flyweight flyweight = null;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                flyweight = FlyweightFactory.getFlyweightTwo();
            } else {
                flyweight = FlyweightFactory.getFlyweightOne();
            }
            flyweight.show();
        }
    }
}
