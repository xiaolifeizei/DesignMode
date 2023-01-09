package com.matrix.bridge;

/**
 * 抽象类子类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:57
 */
public class RefindedAbstractionOne extends Abstraction {

    public RefindedAbstractionOne(Implementor implementor) {
        super(implementor);
    }

    @Override
    protected void request() {
        System.out.println("the one request....");
        super.request();
    }

    @Override
    protected void response() {
        System.out.println("the one response....");
        super.response();
    }
}
