package com.matrix.adapter.classadapter;

/**
 * 类适配器
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:49
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void response() {
        super.request();
    }
}
