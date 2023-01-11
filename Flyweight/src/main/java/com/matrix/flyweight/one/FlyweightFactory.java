package com.matrix.flyweight.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author : cui_feng
 * @since : 2023-01-11 09:16
 */
public class FlyweightFactory {

    /**
     * 对象池
     */
    private static final Map<String, Flyweight> pool = new HashMap<>();


    public static synchronized Flyweight get(String name) {
        if (pool.containsKey(name)) {
            return pool.get(name);
        }

        Flyweight flyweight = new ConcreteFlyweight();
        pool.put(name, flyweight);
        return flyweight;
    }
}
