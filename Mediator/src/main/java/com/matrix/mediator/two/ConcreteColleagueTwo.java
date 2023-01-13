package com.matrix.mediator.two;

/**
 * @author : cui_feng
 * @since : 2023-01-13 12:49
 */
public class ConcreteColleagueTwo extends Colleague{

    public ConcreteColleagueTwo(Mediator mediator) {
        super(mediator);
    }


    public void finish() {
        System.out.println("ConcreteColleagueTwo finish....");
    }

    @Override
    public void changed() {
        System.out.println("ConcreteColleagueTwo changed....");
        mediator.operation(this);
    }
}
