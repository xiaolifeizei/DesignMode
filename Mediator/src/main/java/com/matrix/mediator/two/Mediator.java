package com.matrix.mediator.two;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cui_feng
 * @since : 2023-01-13 11:08
 */
public abstract class Mediator {

    @Getter
    protected final List<Colleague> colleagues = new ArrayList<>();

    public void attach(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            this.colleagues.add(colleague);
        }
    }

    public abstract void operation(Colleague colleague);

    public void close() {
        System.out.println("-------------------------------------");
        colleagues.forEach(item -> {
            if (item instanceof ConcreteColleagueOne) {
                ((ConcreteColleagueOne) item).flash();
            } else {
                ((ConcreteColleagueTwo) item).finish();
            }
        });
    }
}
