package com.matrix.wrapper.one;

/**
 * 具体装饰器1
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:08
 */
public class ConcreteDecoratorFirst extends Decorator{

    public ConcreteDecoratorFirst(Component component) {
        super(component);
    }

    @Override
    public void request() {
        super.request();
        System.out.println("first request");
    }
}
