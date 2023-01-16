package com.matrix.interpreter.fullcalculator;

import lombok.Data;

import java.util.HashMap;

/**
 * 运算符表达式（非终结符表达式）的抽象父类
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:49
 */
@Data
public class SymbolExpression implements Expression {

    private Expression left;
    private Expression right;

    private String operator;

    public SymbolExpression(String operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }


    @Override
    public double interpret(HashMap<String, Double> ctx) {
        switch (operator) {
            case "+":
                return left.interpret(ctx) + right.interpret(ctx);
            case "-":
                return left.interpret(ctx) - right.interpret(ctx) ;
            case "*":
                return left.interpret(ctx) * right.interpret(ctx);
            case "/":
                return left.interpret(ctx) / right.interpret(ctx);
        }
        throw new RuntimeException("不支持的运算符：" + operator);
    }

    @Override
    public String getInterpret(HashMap<String, Double> ctx) {
        StringBuilder sb = new StringBuilder();
        if (left instanceof BracketsExpression) {
            sb.append("(")
                    .append(left.getInterpret(ctx))
                    .append(")");
        } else {
            sb.append(left.getInterpret(ctx));
        }
        sb.append(operator);
        if (right instanceof BracketsExpression) {
            sb.append("(")
                    .append(right.getInterpret(ctx))
                    .append(")");
        } else {
            sb.append(right.getInterpret(ctx));
        }
        return sb.toString();
    }
}
