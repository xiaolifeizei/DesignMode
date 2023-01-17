package com.matrix.strategy.two;

/**
 * 高级会员
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:33
 */
public class AdvanceMemberStrategy extends MemberStrategy{

    /**
     * 打七折
     * @return 价格
     */
    @Override
    public double getPrice() {
        return price * count * 0.7;
    }
}
