package com.matrix.flyweight.two;

import lombok.Data;
import lombok.Getter;

/**
 * 享元抽象类
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:08
 */
public abstract class Flyweight {

    @Getter
    private String type;

    public Flyweight(String type) {
        this.type = type;
    }

    public void show() {
        System.out.println(type + " show....");
    }
}
