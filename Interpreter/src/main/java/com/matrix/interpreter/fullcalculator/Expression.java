package com.matrix.interpreter.fullcalculator;

import java.util.HashMap;

/**
 * 抽象表达式
 *
 * @author : cui_feng
 * @since : 2023-01-15 10:41
 */
public interface Expression {

    /**
     * 表达式的解释操作
     */
    double interpret(HashMap<String, Double> ctx);

    /**
     * 打印解释后的表达式
     * @param ctx 上下文
     * @return exp
     */
    String getInterpret(HashMap<String, Double> ctx);
}
