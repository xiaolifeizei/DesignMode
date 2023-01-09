package com.matrix.wrapper.three;


/**
 * 具体装饰器2
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:08
 */
public class ConcreteDecoratorSecond extends Decorator {

    public ConcreteDecoratorSecond(Component component) {
        super(component,"second");
    }

    @Override
    public void request() {
        System.out.println(getNames() + " request....");
    }
}
