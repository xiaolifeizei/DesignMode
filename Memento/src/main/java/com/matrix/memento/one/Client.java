package com.matrix.memento.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-13 16:35
 */
public class Client {

    public static void main(String[] args) {

        CareTaker taker = new CareTaker();
        Originator originator = new Originator("车");

        originator.setState("1平2");
        System.out.println(originator.getStamp() + "->" + originator.getName() + originator.getState());

        // 备忘一次
        taker.setMemento(originator.save());

        originator.setStamp(System.currentTimeMillis());
        originator.setState("2进8");
        System.out.println(originator.getStamp() + "->" + originator.getName() + originator.getState());

        // 悔棋，恢复到备忘时保存的状态
        originator.recovery(taker.getMemento());
        System.out.println(originator.getStamp() + "->" + originator.getName() + originator.getState());
    }
}
