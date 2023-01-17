package com.matrix.state.lift;

/**
 * 电梯状态
 *
 * @author : cui_feng
 * @since : 2023-01-17 11:10
 */
public abstract class LiftState {

    /**
     * 环境
     */
    protected Context context;

    public void setContext(Context _context) {
        this.context = _context;
    }

    /**
     * 打开电梯
     */
    public void open() {
        throw new RuntimeException("不支持此操作");
    }

    /**
     * 关闭电梯
     */
    public void close() {
        throw new RuntimeException("不支持此操作");
    }

    /**
     * 电梯运行
     */
    public void run() {
        throw new RuntimeException("不支持此操作");
    }

    /**
     * 电梯停止
     */
    public void stop() {
        throw new RuntimeException("不支持此操作");
    }

}
