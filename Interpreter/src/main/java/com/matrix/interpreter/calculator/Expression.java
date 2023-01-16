package com.matrix.interpreter.calculator;

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
    int interpret(HashMap<String, Integer> ctx);
}
