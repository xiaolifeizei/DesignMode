package com.matrix.mediator.two;

import java.util.stream.Collectors;

/**
 * @author : cui_feng
 * @since : 2023-01-13 12:52
 */
public class ConcreteMediator extends Mediator{

    @Override
    public void operation(Colleague colleague) {
        if (colleague instanceof ConcreteColleagueOne) {
            colleagues.stream()
                    .filter(item -> item instanceof ConcreteColleagueTwo)
                    .collect(Collectors.toList())
                    .forEach(item -> ((ConcreteColleagueTwo) item).finish());
        } else {
            colleagues.stream()
                    .filter(item -> item instanceof ConcreteColleagueOne)
                    .collect(Collectors.toList())
                    .forEach(item -> ((ConcreteColleagueOne) item).flash());
        }
    }
}
