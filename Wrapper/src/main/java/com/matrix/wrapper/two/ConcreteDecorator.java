package com.matrix.wrapper.two;

import lombok.Data;

/**
 * 具体装饰器
 * 简化的装饰器模式
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:08
 */
@Data
public class ConcreteDecorator implements Component{

    private Component component;

    public ConcreteDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void request() {
        component.request();
        System.out.println("decorator request");
    }
}
