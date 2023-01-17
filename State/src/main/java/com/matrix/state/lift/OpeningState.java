package com.matrix.state.lift;

/**
 * @author : cui_feng
 * @since : 2023-01-17 11:18
 */
public class OpeningState extends LiftState{

    /**
     * 关闭电梯门
     */
    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.CLOSING_STATE);
        //动作委托为CloseState来执行
        super.context.getLiftState().close();
    }

    /**
     * 打开电梯门
     */
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }
}
