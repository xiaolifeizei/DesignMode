package com.matrix.wrapper.one;

/**
 * 装饰器
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:01
 */
public class Decorator implements Component {

    private final Component component;

    public Decorator (Component component) {
        this.component = component;
    }

    @Override
    public void request() {
        component.request();
    }
}
