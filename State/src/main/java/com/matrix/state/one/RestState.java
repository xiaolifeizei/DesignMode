package com.matrix.state.one;

/**
 * 具体状态角色
 * 下班休息状态
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:06
 */
public class RestState implements State{
    @Override
    public void writeProgram(Work work) {
        System.err.println("当前时间: 下班回家了。"+work.getHour()+"点");
    }
}
