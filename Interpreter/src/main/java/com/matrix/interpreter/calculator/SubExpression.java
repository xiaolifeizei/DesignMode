package com.matrix.interpreter.calculator;

import java.util.HashMap;

/**
 * 减法表达式
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:54
 */
public class SubExpression extends SymbolExpression{

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(HashMap<String, Integer> variable) {
        return left.interpret(variable) - right.interpret(variable);
    }
}
