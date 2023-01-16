package com.matrix.interpreter.fullcalculator;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 客户端角色
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:55
 */
public class Calculator {

    private final Expression expression;

    private final HashMap<String, Double> ctx;

    public Calculator(String exp) {
        this.ctx = null;
        this.expression = resolveExpression(getSyntaxWords(exp));
    }

    public Calculator(String exp, HashMap<String, Double> ctx) {
        this.ctx = ctx;
        this.expression = resolveExpression(getSyntaxWords(exp));
    }

    private List<String> getSyntaxWords(String exp) {
        List<String> syntaxWords = new ArrayList<>();
        List<String> words = Arrays.asList(exp.split("\\.?"));
        words.removeAll(Collections.singleton(" "));

        StringBuilder key = new StringBuilder();
        for (String word : words) {
            if ("(+-*/)".contains(word)) {
                if (key.length() > 0) {
                    syntaxWords.add(key.toString());
                    key = new StringBuilder();
                }
                syntaxWords.add(word);

            } else {
                key.append(word);
            }
        }
        if (key.length() > 0) {
            syntaxWords.add(key.toString());
        }
        return syntaxWords;
    }

    private Expression resolveExpression(List<String> words) {
        // 语法树
        Stack<Expression> syntaxTree = new Stack<>();

        Expression left;
        Expression right;

        try {
            for (int i=0; i<words.size(); i++) {
                String word = words.get(i);
                switch (word) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        String next = words.get(++i);
                        if (next.equals("(")) {
                            int end = getBracketEndIndex(words.subList(i+1, words.size()));
                            right = new BracketsExpression(resolveExpression(words.subList(i+1, end + i)));
                            i = end + i;
                        } else {
                            right = new TerminalExpression(next);
                        }

                        if ("*/".contains(word)) {
                            Expression preExpression = syntaxTree.pop();
                            if (preExpression instanceof SymbolExpression) {
                                left = ((SymbolExpression) preExpression).getRight();
                                ((SymbolExpression) preExpression).setRight(new SymbolExpression(word, left, right));
                                syntaxTree.push(preExpression);
                                break;
                            } else {
                                left = preExpression;
                            }
                        } else {
                            left = syntaxTree.pop();
                        }

                        syntaxTree.push(new SymbolExpression(word, left, right));
                        break;
                    case "(":
                        int end = getBracketEndIndex(words.subList(i+1, words.size()));
                        syntaxTree.push(new BracketsExpression(resolveExpression(words.subList(i+1, end + i))));
                        i = end + i;
                        break;
                    default:
                        syntaxTree.push(new TerminalExpression(word));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("语法错误");
        }

        if (syntaxTree.size() != 1) {
            throw new RuntimeException("语法错误");
        }

        return syntaxTree.pop();
    }

    private int getBracketEndIndex(List<String> subExpression) {
        int leftBracketsCount = 0;
        int endIndex = -1;
        for (int i=0; i<subExpression.size(); i++) {
            String key = subExpression.get(i);
            if (key.equals("(")) {
                leftBracketsCount++;
            }
            if (key.equals(")")) {
                if (leftBracketsCount == 0) {
                    endIndex = i + 1;
                    return endIndex;
                } else {
                    leftBracketsCount--;
                }
            }
        }
        return endIndex;
    }

    /**
     * 执行计算
     * @param ctx 上下文
     * @return 计算结果
     */
    public final double calculate(HashMap<String, Double> ctx) {
        return expression.interpret(ctx);
    }

    public final double calculate() {
        return expression.interpret(ctx);
    }

    public final String getInterpret(HashMap<String, Double> ctx) {
        return expression.getInterpret(ctx);
    }

    public final String getInterpret() {
        return expression.getInterpret(ctx);
    }
}
