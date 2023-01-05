package com.matrix.singleton.inner;

/**
 * 静态内部类
 * 多线程安全：是
 * 懒加载：是
 *
 * @author : cui_feng
 * @since : 2023-01-05 11:56
 */
public class Singleton {

    /**
     * 私有化构造方法
     */
    private Singleton() {

    }

    private static final class SingletonHolder {
        static final Singleton singleton = new Singleton();
    }

    //静态工厂方法
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }
}
