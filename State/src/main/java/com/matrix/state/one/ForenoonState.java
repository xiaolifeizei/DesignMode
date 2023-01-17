package com.matrix.state.one;

/**
 * 具体状态角色
 * 上午工作
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:00
 */
public class ForenoonState implements State{
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.err.println("当前时间:上午" + work.getHour() + "点");
        } else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
