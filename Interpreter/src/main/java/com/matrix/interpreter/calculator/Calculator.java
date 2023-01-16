package com.matrix.interpreter.calculator;

import java.util.*;

/**
 * 客户端角色
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:55
 */
public class Calculator {

    private final Expression expression;

    public Calculator(String exp) {
        this.expression = resolveExpression(exp);
    }

    private Expression resolveExpression(String exp) {
        // 语法树
        Stack<Expression> syntaxTree = new Stack<>();

        // 表达式拆分为字符数组
        char [] charArray = exp.toCharArray();

        // 运算
        Expression left;
        Expression right;

        try {
            for (int i = 0; i < charArray.length; i++) {
                switch (charArray[i]) {
                    // 加法运算符
                    case '+':
                        left = syntaxTree.pop();
                        right = new TerminalExpression(exp.substring(++i));
                        // 构造加法运算表达式
                        syntaxTree.push(new AddExpression(left, right));
                        break;
                    // 减法
                    case '-':
                        left = syntaxTree.pop();
                        right = new TerminalExpression(exp.substring(++i));
                        // 构造减法表达式
                        syntaxTree.push(new SubExpression(left, right));
                        break;
                    // 不是运算符时就是终结表达式
                    default:
                        syntaxTree.push(new TerminalExpression(String.valueOf(charArray[i])));
                }
            }

            // 只能有一棵语法树
            if (syntaxTree.size() > 1) {
                throw new IllegalArgumentException("表达式语法错误");
            }
            // 得到最终表达式
            return syntaxTree.pop();
        } catch (Exception e) {
            throw new IllegalArgumentException("表达式语法错误。。。。");
        }
    }

    /**
     * 执行计算
     * @param ctx 上下文
     * @return 计算结果
     */
    public int calculate(HashMap<String, Integer> ctx) {
        return expression.interpret(ctx);
    }
}
