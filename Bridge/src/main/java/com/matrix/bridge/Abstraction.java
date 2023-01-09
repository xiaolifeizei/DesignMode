package com.matrix.bridge;

/**
 * 抽象类（桥接类）
 * 维护了 implementor，二者是聚合关系
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:55
 */
public abstract class Abstraction {
    private final Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    protected void request() {
        implementor.request();
    }

    protected void response() {
        implementor.response();
    }

    public void show() {
        System.out.println("do show....");
    }
}
