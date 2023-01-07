package com.matrix.factory.factorymethod.two;

/**
 * 工厂类接口
 * 由子类决定实例化
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:32
 */
public interface SubjectFactory {

    /**
     * 创建对象放到子类
     * @return SubjectFirst
     */
    Subject getSubject();
}
