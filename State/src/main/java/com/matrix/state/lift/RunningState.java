package com.matrix.state.lift;

/**
 * @author : cui_feng
 * @since : 2023-01-17 11:20
 */
public class RunningState extends LiftState{

    @Override
    public void run() {
        System.out.println("电梯正在运行...");
    }

    /**
     * 电梯停止
     */
    @Override
    public void stop() {
        //环境设置为停止状态；
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.getLiftState().stop();
    }
}
