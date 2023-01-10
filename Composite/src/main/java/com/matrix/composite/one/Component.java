package com.matrix.composite.one;

/**
 * 抽象构件
 * 安全性合成模式
 *  从客户端使用合成模式上看是否更安全，如果是安全的，那么就不会有发生误操作的可能，能访问的方法都是被支持的。
 *  从客户端的角度看树叶节点和叶子节点需要分开
 *
 * @author : cui_feng
 * @since : 2023-01-10 13:13
 */
public interface Component {

    void show();
}
