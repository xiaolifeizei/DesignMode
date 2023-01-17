package com.matrix.strategy.two;

/**
 * 普通会员策略
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:27
 */
public class OrdinaryMemberStrategy extends MemberStrategy {


    /**
     * 不打折
     * @return 价格
     */
    @Override
    public double getPrice() {
        return price * count;
    }
}
