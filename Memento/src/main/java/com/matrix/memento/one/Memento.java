package com.matrix.memento.one;

import lombok.Data;

/**
 * 备忘录，宽接口实现方式
 *
 * @author : cui_feng
 * @since : 2023-01-13 16:29
 */
@Data
public class Memento {

    private String name;

    private Long stamp;

    private String state;

    private Long saveTime;

    public Memento(Originator originator) {
        this.name = originator.getName();
        this.stamp = originator.getStamp();
        this.state = originator.getState();
        this.saveTime = System.currentTimeMillis();
    }
}
