package com.matrix.wrapper.three;


/**
 * 具体装饰器1
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:08
 */
public class ConcreteDecoratorFirst extends Decorator {

    public ConcreteDecoratorFirst(Component component) {
        super(component,"first");
    }

    @Override
    public void request() {
        System.out.println(getNames() + " request....");
    }
}
