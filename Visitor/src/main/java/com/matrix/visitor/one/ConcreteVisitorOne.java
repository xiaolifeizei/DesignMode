package com.matrix.visitor.one;

/**
 * 具体访问者1
 *
 * @author : cui_feng
 * @since : 2023-01-17 16:36
 */
public class ConcreteVisitorOne implements Visitor{
    @Override
    public void visit(ElementFirst first) {
        System.out.print("ConcreteVisitorOne-->");
        first.request();
    }

    @Override
    public void visit(ElementSecond second) {
        System.out.print("ConcreteVisitorOne-->");
        second.response();
    }
}
