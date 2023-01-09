package com.matrix.bridge;

/**
 * 使用
 * 把抽象（Abstraction）与行为实现（Implementation）分离开来，
 * 从而可以保持各部分的独立性以及他们的功能扩展，通过桥接模式可以使
 * 两种类型相互排列组合，极大的提供了系统的灵活性
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:55
 */
public class Client {

    public static void main(String[] args) {
        Abstraction oneFist = new RefindedAbstractionOne(new ConcreteImplementorFirst());
        Abstraction oneSecond = new RefindedAbstractionOne(new ConcreteImplementorSecond());
        Abstraction twoFirst = new RefindedAbstractionTwo(new ConcreteImplementorFirst());
        Abstraction twoSecond = new RefindedAbstractionTwo(new ConcreteImplementorSecond());

        oneFist.request();
        oneFist.response();
        oneFist.show();

        System.out.println("=============================================");

        oneSecond.request();
        oneSecond.response();
        oneSecond.show();

        System.out.println("=============================================");

        twoFirst.request();
        twoFirst.response();
        twoFirst.show();

        System.out.println("=============================================");

        twoSecond.request();
        twoSecond.response();
        twoSecond.show();
    }
}
