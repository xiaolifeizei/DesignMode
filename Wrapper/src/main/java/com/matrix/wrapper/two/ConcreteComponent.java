package com.matrix.wrapper.two;

/**
 * 只有一个构件实例
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:00
 */
public class ConcreteComponent implements Component {

    @Override
    public void request() {
        System.out.println("component request....");
    }
}
