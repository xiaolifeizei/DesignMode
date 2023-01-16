package com.matrix.interpreter.calculator;

import java.util.HashMap;

/**
 * 终结符表达式
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:45
 */
public class TerminalExpression implements Expression{


    private final String key;

    public TerminalExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpret(HashMap<String, Integer> ctx) {
        return ctx.get(this.key);
    }
}
