package com.matrix.observer.jdk;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:24
 */
public class ConcreteSubject extends Observable {

    @Getter
    private String state = "init";

    public void change(String state) {
        this.state = state;
        super.setChanged();
        super.notifyObservers(getTimeNow());
    }

    private String getTimeNow () {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
}
