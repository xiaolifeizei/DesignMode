package com.matrix.state.one;

/**
 * 具体状态角色
 * 睡眠状态
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:06
 */
public class SleepingState implements State{
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.err.println("当前时间: 不行了，睡着了。" + work.getHour() + "点");
        }
    }
}
