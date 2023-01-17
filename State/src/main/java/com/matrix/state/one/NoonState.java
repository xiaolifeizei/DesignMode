package com.matrix.state.one;

/**
 * 具体状态角色
 * 中午工作
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:02
 */
public class NoonState implements State{
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.err.println("当前时间: 下午"+work.getHour()+"点");
        } else {
            work.setState(new AfterNoonState());
            work.writeProgram();
        }
    }
}
