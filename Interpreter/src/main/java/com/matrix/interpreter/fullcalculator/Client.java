package com.matrix.interpreter.fullcalculator;

import java.util.HashMap;

/**
 * 使用
 * 加减乘除四则运算，包括括号
 *
 * @author : cui_feng
 * @since : 2023-01-15 11:04
 */
public class Client {

    public static void main(String[] args) {
        // 构造运算元素的值列表
        HashMap<String, Double> ctx = new HashMap<>();
        ctx.put("aa", 1d);
        ctx.put("bb", 2d);
        ctx.put("c", 3d);
        ctx.put("dd", 4d);
        ctx.put("e", 5d);
        ctx.put("f", 6d);

        Calculator calc = new Calculator("f*(((bb+c))*dd)");
        double result = calc.calculate(ctx);

        System.out.println("计算过程：" + calc.getInterpret(ctx));
        System.out.println("计算结果: " + result);
        System.out.println("--------------------------------");

        calc = new Calculator("aa-bb-c+dd");
        result = calc.calculate(ctx);
        System.out.println("计算过程：" + calc.getInterpret(ctx));
        System.out.println("计算结果: " + result);
        System.out.println("--------------------------------");

        calc = new Calculator("aa-(bb-c)*dd/e", ctx);
        result = calc.calculate();
        System.out.println("计算过程：" + calc.getInterpret());
        System.out.println("计算结果: " + result);
        System.out.println("--------------------------------");

        calc = new Calculator("(aa/(bb-c)+f)*dd/(e-f)", ctx);
        System.out.println("计算过程：" + calc.getInterpret());
        System.out.println("计算结果: " + calc.calculate());
    }
}
