package com.matrix.wrapper.one;

/**
 * 构件1
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:00
 */
public class ConcreteComponentOne implements Component{

    @Override
    public void request() {
        System.out.println("one request....");
    }
}
