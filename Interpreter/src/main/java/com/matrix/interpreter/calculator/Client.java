package com.matrix.interpreter.calculator;

import java.util.HashMap;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-15 11:04
 */
public class Client {

    public static void main(String[] args) {
        // 构造运算元素的值列表
        HashMap<String, Integer> ctx = new HashMap<>();
        ctx.put("a", 10);
        ctx.put("b", 20);
        ctx.put("c", 30);
        ctx.put("d", 40);
        ctx.put("e", 50);
        ctx.put("f", 60);

        Calculator calc = new Calculator("a+a+c+d");
        int result = calc.calculate(ctx);
        System.out.println("Calculate result: " + result);

        calc = new Calculator("d-a-b+c");
        result = calc.calculate(ctx);
        System.out.println("Calculate result: " + result);
    }
}
