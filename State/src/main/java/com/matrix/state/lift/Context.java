package com.matrix.state.lift;

/**
 * @author : cui_feng
 * @since : 2023-01-17 11:17
 */
public class Context {

    // 定义出所有的电梯状态
    public final static LiftState OPENING_STATE = new OpeningState();
    public final static LiftState CLOSING_STATE = new ClosingState();
    public final static LiftState RUNNING_STATE = new RunningState();
    public final static LiftState STOPPING_STATE = new StoppingState();

    {
        CLOSING_STATE.setContext(this);
        OPENING_STATE.setContext(this);
        RUNNING_STATE.setContext(this);
        STOPPING_STATE.setContext(this);
    }

    // 定一个当前电梯状态
    private LiftState liftState = CLOSING_STATE;


    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
