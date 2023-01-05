package com.matrix.singleton.lazy;

import lombok.Data;

/**
 * 懒汉式
 *
 * @author : cui_feng
 * @since : 2023-01-05 11:43
 */
@Data
public class Singleton {

    // volatile 禁止重排
    private volatile static Singleton singleton = null;

    /**
     * 私有化构造方法
     */
    private Singleton() {

    }

    //静态工厂方法
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                // DCL 双重检查锁
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
