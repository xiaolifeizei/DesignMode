package com.matrix.mediator.one;

/**
 * 具体同事类
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:38
 */
public class ConcreteColleagueOne extends Colleague{

    public ConcreteColleagueOne(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void contact(String msg) {
        mediator.contact(msg, this);
    }
}
