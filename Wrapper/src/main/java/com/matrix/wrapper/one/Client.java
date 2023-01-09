package com.matrix.wrapper.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:10
 */
public class Client {

    public static void main(String[] args) {
        // 原始构件ConcreteComponentOne
        Component one = new ConcreteComponentOne();
        // 将原始构件包装成了ConcreteDecoratorFirst
        Component one2first = new ConcreteDecoratorFirst(one);
        // 将原始构件包装成了ConcreteDecoratorSecond
        Component one2second = new ConcreteDecoratorSecond(one);
        one2first.request();
        System.out.println();
        one2second.request();

        System.out.println("===============================================");

        // 原始构件ConcreteComponentTwo
        Component two = new ConcreteComponentTwo();
        // 将原始构件包装成了ConcreteDecoratorFirst
        Component two2first = new ConcreteDecoratorFirst(two);
        // 将ConcreteDecoratorFirst包装成了ConcreteDecoratorSecond
        Component two2first2second = new ConcreteDecoratorSecond(two2first);
        two2first.request();
        System.out.println();
        two2first2second.request();
    }
}
