package com.matrix.memento.one;

import lombok.Data;

/**
 * 源发起类
 *
 * @author : cui_feng
 * @since : 2023-01-13 16:27
 */
@Data
public class Originator {

    private String name;

    private Long stamp;

    private String state;

    public Originator(String name) {
        this.name = name;
        this.stamp = System.currentTimeMillis();
    }

    public Memento save() {
        return new Memento(this);
    }

    public void recovery(Memento memento) {
        this.name = memento.getName();
        this.stamp = memento.getStamp();
        this.state = memento.getState();
    }
}
