package com.matrix.interpreter.fullcalculator;

import java.util.HashMap;

/**
 * 终结符表达式
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:45
 */
public class TerminalExpression implements Expression {


    private final String key;

    public TerminalExpression(String key) {
        this.key = key;
    }

    @Override
    public double interpret(HashMap<String, Double> ctx) {
        Double value = ctx.get(this.key);
        if (value == null) {
            throw new RuntimeException("计算错误，没有找到" + key + "的值");
        }
        return  value;
    }

    @Override
    public String getInterpret(HashMap<String, Double> ctx) {
        return ctx.get(this.key).toString();
    }
}
