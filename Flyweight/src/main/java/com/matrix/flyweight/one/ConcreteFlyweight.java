package com.matrix.flyweight.one;

/**
 * 享元对象1
 *
 * @author : cui_feng
 * @since : 2023-01-11 09:15
 */
public class ConcreteFlyweight implements Flyweight{
    @Override
    public void request() {
        System.out.println("ConcreteFlyweight request....");
    }
}
