package com.matrix.strategy.two;

import lombok.Setter;

/**
 * @author : cui_feng
 * @since : 2023-01-17 13:33
 */
public class Context {

    @Setter
    private MemberStrategy memberStrategy;

    public double getPrice(double price, int count) {
        memberStrategy.setPrice(price);
        memberStrategy.setCount(count);
        return memberStrategy.getPrice();
    }
}
