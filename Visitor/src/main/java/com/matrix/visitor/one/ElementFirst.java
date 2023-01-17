package com.matrix.visitor.one;

/**
 * 第一个具体元素
 *
 * @author : cui_feng
 * @since : 2023-01-17 16:38
 */
public class ElementFirst implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void request() {
        System.out.println("ElementFirst request....");
    }
}
