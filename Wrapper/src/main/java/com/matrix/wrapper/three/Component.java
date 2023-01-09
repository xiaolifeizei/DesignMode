package com.matrix.wrapper.three;

import lombok.Getter;

/**
 * 构件抽象类
 *
 * @author : cui_feng
 * @since : 2023-01-09 15:59
 */
public abstract class Component {

    @Getter
    private final String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void request();
}
