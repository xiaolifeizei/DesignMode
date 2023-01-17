package com.matrix.strategy.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:25
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new ConcreteStrategyOne());
        context.request();

        context.setStrategy(new ConcreteStrategyTwo());
        context.request();
    }
}
