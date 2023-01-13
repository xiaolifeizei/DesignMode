package com.matrix.mediator.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:44
 */
public class Client {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague one = new ConcreteColleagueOne(mediator);
        Colleague two = new ConcreteColleagueTwo(mediator);

        mediator.setColleagueOne(one);
        mediator.setColleagueTwo(two);

        one.contact("is any body here?");
        two.contact("I'm here!");
    }
}
