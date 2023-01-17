package com.matrix.visitor.one;

/**
 * 抽象访问者
 *
 * @author : cui_feng
 * @since : 2023-01-17 16:35
 */
public interface Visitor {

    /**
     * 对应于NodeA的访问操作
     */
    void visit(ElementFirst first);
    /**
     * 对应于NodeB的访问操作
     */
    void visit(ElementSecond second);
}
