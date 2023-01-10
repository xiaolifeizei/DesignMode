package com.matrix.composite.two;

import lombok.Getter;

/**
 * 树叶构件
 *
 * @author : cui_feng
 * @since : 2023-01-10 13:20
 */
public class Leaf extends Component {

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
