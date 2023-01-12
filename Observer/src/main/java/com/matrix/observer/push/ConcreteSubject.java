package com.matrix.observer.push;

/**
 * 具体主题角色类
 *
 * @author : cui_feng
 * @since : 2023-01-12 10:39
 */
public class ConcreteSubject extends Subject{

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.notifyObservers(state);
    }
}
