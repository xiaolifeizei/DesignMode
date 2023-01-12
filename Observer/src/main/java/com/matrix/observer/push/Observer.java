package com.matrix.observer.push;

/**
 * 抽象观察者角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 10:36
 */
public interface Observer {

    /**
     * 更新接口
     * @param state 更新的状态
     */
    void update(String state);
}
