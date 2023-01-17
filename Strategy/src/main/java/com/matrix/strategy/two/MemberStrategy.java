package com.matrix.strategy.two;

import lombok.Data;

/**
 * @author : cui_feng
 * @since : 2023-01-17 13:27
 */
@Data
public abstract class MemberStrategy {

    protected double price;

    protected int count;

    public abstract double getPrice();
}
