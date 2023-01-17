package com.matrix.strategy.two;

/**
 * 中级会员策略
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:31
 */
public class IntermediateMemberStrategy extends MemberStrategy {

    /**
     * 打九折
     * @return 价格
     */
    @Override
    public double getPrice() {
        return price * count * 0.9;
    }
}
