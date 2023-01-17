package com.matrix.strategy.one;

/**
 * 策略2
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:24
 */
public class ConcreteStrategyTwo implements Strategy{
    @Override
    public void request() {
        System.out.println("ConcreteStrategyTwo request....");
    }
}
