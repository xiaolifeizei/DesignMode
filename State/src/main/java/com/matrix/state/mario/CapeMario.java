package com.matrix.state.mario;

/**
 * @author : cui_feng
 * @since : 2023-01-17 10:53
 */
public class CapeMario implements Mario{

    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        // 当前状态要干的事
        stateMachine.setCurrentState(SmallMario.getInstance());
        // 过渡到下一个状态
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
