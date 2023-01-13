package com.matrix.mediator.one;

import lombok.Data;

/**
 * 具体中介者
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:40
 */
@Data
public class ConcreteMediator implements Mediator{

    private Colleague colleagueOne;

    private Colleague colleagueTwo;

    @Override
    public void contact(String msg, Colleague colleague) {
        if (colleague instanceof ConcreteColleagueOne) {
            colleagueTwo.show(msg);
        } else {
            colleagueOne.show(msg);
        }
    }
}
