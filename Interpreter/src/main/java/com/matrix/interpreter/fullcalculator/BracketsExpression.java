package com.matrix.interpreter.fullcalculator;

import lombok.Data;

import java.util.HashMap;

/**
 * 括号表达式（非终结符表达式）
 *
 * @author : cui_feng
 * @since : 2023-01-16 13:46
 */
@Data
public class BracketsExpression implements Expression{

    private Expression expression;

    public BracketsExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double interpret(HashMap<String, Double> ctx) {
        return expression.interpret(ctx);
    }

    @Override
    public String getInterpret(HashMap<String, Double> ctx) {
        StringBuilder sb = new StringBuilder();
        if (expression instanceof BracketsExpression) {
            sb.append("(")
                    .append(expression.getInterpret(ctx))
                    .append(")");
        } else {
            sb.append(expression.getInterpret(ctx));
        }
        return sb.toString();
    }
}
