package com.matrix.mediator.one;

/**
 * 抽象中介者
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:34
 */
public interface Mediator {

    void contact(String msg, Colleague colleague);
}
