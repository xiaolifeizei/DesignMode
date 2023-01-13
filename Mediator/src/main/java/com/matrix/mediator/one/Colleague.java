package com.matrix.mediator.one;

/**
 * 抽象同事类
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:36
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void contact(String msg);

    public void show(String msg) {
        System.out.println(this.getClass().getSimpleName() + " copy:" + msg);
    }
}
