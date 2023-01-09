package com.matrix.wrapper.three;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:46
 */
public class Client {

    public static void main(String[] args) {

        Component one = new ConcreteComponentOne();
        Component two = new ConcreteComponentTwo();

        Component onePlusFirst = new ConcreteDecoratorFirst(one);
        Component onePlusSecond = new ConcreteDecoratorSecond(one);

        Component twoPlusFirst = new ConcreteDecoratorFirst(two);
        Component twoPlusSecond = new ConcreteDecoratorSecond(two);

        Component onePlusFirstPlusSecond = new ConcreteDecoratorSecond(new ConcreteDecoratorFirst(one));
        Component twoPlusSecondPlusFirst = new ConcreteDecoratorFirst(new ConcreteDecoratorSecond(two));

        one.request();
        two.request();

        System.out.println("================================");

        onePlusFirst.request();
        onePlusSecond.request();

        System.out.println("================================");

        twoPlusFirst.request();
        twoPlusSecond.request();

        System.out.println("================================");

        onePlusFirstPlusSecond.request();
        twoPlusSecondPlusFirst.request();
    }
}
