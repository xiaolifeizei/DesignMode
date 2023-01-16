package com.matrix.interpreter.calculator;

import java.util.HashMap;

/**
 * 加法表达式
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:52
 */
public class AddExpression extends SymbolExpression{

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(HashMap<String, Integer> variable) {
        return super.left.interpret(variable) + super.right.interpret(variable);
    }
}
