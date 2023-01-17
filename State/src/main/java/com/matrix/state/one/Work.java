package com.matrix.state.one;

import lombok.Data;

/**
 * @author : cui_feng
 * @since : 2023-01-17 09:59
 */
@Data
public class Work {

    private int hour;

    private Boolean finish = false;

    private State state;

    public Work() {
        // 设置起始状态
        state = new ForenoonState();
    }


    public void writeProgram() {
        this.state.writeProgram(this);
    }
}
