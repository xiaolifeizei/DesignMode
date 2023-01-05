package com.matrix.dm.hunger;

/**
 * 饿汉式
 *
 * @author : cui_feng
 * @since : 2023-01-05 11:51
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
