package com.matrix.flyweight.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:14
 */
public class FlyweightFactory {

    private static final Map<String, Flyweight> pool = new HashMap<>();

    static {
        Flyweight flyweightOne = new ConcreteFlyweightOne();
        Flyweight flyweightTwo = new ConcreteFlyweightTwo();
        pool.put("one", flyweightOne);
        pool.put("two", flyweightTwo);
    }

    public static Flyweight getFlyweightOne() {
        return pool.get("one");
    }

    public static Flyweight getFlyweightTwo() {
        return pool.get("two");
    }
}
