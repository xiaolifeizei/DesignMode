package com.matrix.state.mario;

/**
 * 马里奥例子
 *
 * @author : cui_feng
 * @since : 2023-01-17 10:53
 */
public class Client {

    public static void main(String[] args) {
        //初始化
        System.out.println("===========游戏开始===========");
        MarioStateMachine mario = new MarioStateMachine();
        State currentState = mario.getCurrentState();
        System.out.println(mario.getScore());
        System.out.println(currentState);
        //吃蘑菇
        System.out.println("===========吃蘑菇===========");
        mario.obtainMushRoom();
        currentState = mario.getCurrentState();
        System.out.println(mario.getScore());
        System.out.println(currentState);
        //获得斗篷
        System.out.println("============获得斗篷==========");
        mario.obtainCape();
        currentState = mario.getCurrentState();
        System.out.println(mario.getScore());
        System.out.println(currentState);

        //遇到怪物
        System.out.println("===========遇到怪物===========");
        mario.meetMonster();
        currentState = mario.getCurrentState();
        System.out.println(mario.getScore());
        System.out.println(currentState);

        //获得火焰
        System.out.println("============获得火焰==========");
        mario.obtainFireFlower();
        currentState = mario.getCurrentState();
        System.out.println(mario.getScore());
        System.out.println(currentState);
    }
}
