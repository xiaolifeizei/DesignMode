package com.matrix.proxy.dynamic.cglib;

/**
 * 被代理的类
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:37
 */
public class Subject {

    public void request() {
        System.out.println("doing request....");
    }

    public void response() {
        System.out.println("doing response....");
    }

    public static void testStatic() {
        System.out.println("doing testStatic....");
    }

    public final void testFinal() {
        System.out.println("doing testFinal....");
    }
}
