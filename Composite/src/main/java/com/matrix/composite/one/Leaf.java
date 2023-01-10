package com.matrix.composite.one;

import lombok.Data;
import lombok.Getter;

/**
 * 树叶构件
 *
 * @author : cui_feng
 * @since : 2023-01-10 13:20
 */
public class Leaf implements Component{

    @Getter
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
