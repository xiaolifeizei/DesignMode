package com.matrix.interpreter.springel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author : cui_feng
 * @since : 2023-01-16 18:24
 */
public class Client {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("(#a+#b)/#c");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("a", 2);
        context.setVariable("b", 4);
        context.setVariable("c", 3);
        System.out.println(expression.getValue(context));
    }
}
