package com.matrix.visitor.one;

/**
 * 抽象元素
 *
 * @author : cui_feng
 * @since : 2023-01-17 16:37
 */
public interface Element {

    void accept(Visitor visitor);
}
