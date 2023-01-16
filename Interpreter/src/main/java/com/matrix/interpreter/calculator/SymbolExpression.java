package com.matrix.interpreter.calculator;

import java.util.HashMap;

/**
 * 运算符表达式（非终结符表达式）的抽象父类
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:49
 */
public abstract class SymbolExpression implements Expression{

    protected final Expression left;
    protected final Expression right;

    /**
     * 非终结符表达式的解释操作只关心自己左右两个表达式的结果
     *
     * @param left 左侧表达式
     * @param right 右侧表达式
     */
    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
