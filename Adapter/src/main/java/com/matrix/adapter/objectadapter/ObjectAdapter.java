package com.matrix.adapter.objectadapter;


import lombok.Getter;

/**
 * 对象适配器
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:40
 */
public class ObjectAdapter implements Target {

    @Getter
    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void response() {
        adaptee.request();
    }
}
