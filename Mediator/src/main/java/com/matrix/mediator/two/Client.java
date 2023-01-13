package com.matrix.mediator.two;

/**
 * @author : cui_feng
 * @since : 2023-01-13 13:02
 */
public class Client {

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();
        Colleague one = new ConcreteColleagueOne(mediator);
        Colleague two = new ConcreteColleagueTwo(mediator);

        mediator.attach(new ConcreteColleagueTwo(mediator));

        one.changed();
        two.changed();

        mediator.close();
    }
}
