package com.matrix.state.mario;

/**
 * 所有状态封装到枚举里
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:45
 */
public enum State {

    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
