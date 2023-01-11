package com.matrix.templatemethod.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:53
 */
public class Client {

    public static void main(String[] args) {
        ConcreteClassOne one = new ConcreteClassOne();
        ConcreteClassTwo two = new ConcreteClassTwo();

        one.show();
        two.show();
    }
}
