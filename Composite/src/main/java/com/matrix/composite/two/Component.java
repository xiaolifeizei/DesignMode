package com.matrix.composite.two;

import java.util.List;

/**
 * 抽象构件
 * 透明式组合模式
 *  从客户端使用合成模式上，是否需要区分到底是“树枝对象”还是“树叶对象”。
 *  如果是透明的，那就不用区分，对于客户而言，都是Compoent对象
 *  具体的类型对于客户端而言是透明的，是无须关心的。
 *
 * @author : cui_feng
 * @since : 2023-01-10 14:37
 */
public abstract class Component {

    public abstract void show();

    public void addChildren(Component children) {
        throw new UnsupportedOperationException("对象不支持此功能");
    }

    public void removeChildren(int index){
        throw new UnsupportedOperationException("对象不支持此功能");
    }

    public List<Component> getChildren() {
        throw new UnsupportedOperationException("对象不支持此功能");
    }
}
