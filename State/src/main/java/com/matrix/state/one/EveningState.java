package com.matrix.state.one;

/**
 * 具体状态角色
 * 晚上工作状态
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:05
 */
public class EveningState implements State{
    @Override
    public void writeProgram(Work work) {
        if (work.getFinish()) {
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                System.err.println("当前时间:加班哦，疲累" + work.getHour() + "点");
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
