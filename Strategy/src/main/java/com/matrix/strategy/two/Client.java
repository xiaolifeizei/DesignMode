package com.matrix.strategy.two;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:35
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setMemberStrategy(new OrdinaryMemberStrategy());
        System.out.println("普通会员：" + context.getPrice(100, 10));

        context.setMemberStrategy(new IntermediateMemberStrategy());
        System.out.println("中级会员：" + context.getPrice(100, 10));

        context.setMemberStrategy(new AdvanceMemberStrategy());
        System.out.println("高级会员：" + context.getPrice(100, 10));

    }
}
