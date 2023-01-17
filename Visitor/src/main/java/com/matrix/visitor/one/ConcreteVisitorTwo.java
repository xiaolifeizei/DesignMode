package com.matrix.visitor.one;

/**
 * 具体访问者2
 *
 * @author : cui_feng
 * @since : 2023-01-17 16:36
 */
public class ConcreteVisitorTwo implements Visitor{

    @Override
    public void visit(ElementFirst first) {
        System.out.print("ConcreteVisitorTwo-->");
        first.request();
    }

    @Override
    public void visit(ElementSecond second) {
        System.out.print("ConcreteVisitorTwo-->");
        second.response();
    }
}
