package com.matrix.state.lift;

/**
 * 电梯停止
 *
 * @author : cui_feng
 * @since : 2023-01-17 11:11
 */
public class StoppingState extends LiftState{

    @Override
    public void open() {
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUNNING_STATE);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}
