package com.matrix.state.mario;

/**
 * @author : cui_feng
 * @since : 2023-01-17 10:44
 */
public interface Mario {

    State getName();

    /**
     * 吃到蘑菇
     * @param stateMachine 状态机
     */
    void obtainMushRoom(MarioStateMachine stateMachine);

    /**
     * 获得斗篷
     * @param stateMachine 状态机
     */
    void obtainCape(MarioStateMachine stateMachine);

    /**
     * 获得火焰
     * @param stateMachine 状态机
     */
    void obtainFireFlower(MarioStateMachine stateMachine);

    /**
     * 遇到怪物
     * @param stateMachine 状态机
     */
    void meetMonster(MarioStateMachine stateMachine);
}
