package com.matrix.mediator.two;

/**
 * @author : cui_feng
 * @since : 2023-01-13 12:49
 */
public class ConcreteColleagueOne extends Colleague{

    public ConcreteColleagueOne(Mediator mediator) {
        super(mediator);
    }

    public void flash() {
        System.out.println("ConcreteColleagueOne flash....");
    }

    @Override
    public void changed() {
        System.out.println("ConcreteColleagueOne changed....");
        mediator.operation(this);
    }
}
