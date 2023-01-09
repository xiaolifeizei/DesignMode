package com.matrix.wrapper.two;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:31
 */
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new ConcreteDecorator(component);
        decorator.request();
    }
}
