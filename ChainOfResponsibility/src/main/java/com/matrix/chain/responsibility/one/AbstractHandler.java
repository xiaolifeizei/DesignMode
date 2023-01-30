package com.matrix.chain.responsibility.one;

/**
 * 抽象处理者
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:27
 */
public abstract class AbstractHandler {

    /**
     * 下一关用当前抽象类来接收
     */
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract int handler();
}
