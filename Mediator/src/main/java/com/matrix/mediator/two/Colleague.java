package com.matrix.mediator.two;

/**
 * @author : cui_feng
 * @since : 2023-01-13 11:09
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.attach(this);
    }

    /**
     * 数据更改方法
     */
    public abstract void changed();
}
