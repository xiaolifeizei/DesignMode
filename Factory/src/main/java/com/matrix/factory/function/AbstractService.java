package com.matrix.factory.function;

/**
 * 服务父类
 * 1、定义了创建对象的接口：public abstract Subject createSubject(String type);
 * 2、由子类决定实例化
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:32
 */
public abstract class AbstractService {

    /**
     * 创建对象放到子类
     * @param type
     * @return
     */
    public abstract Subject createSubject(String type);

    /**
     * 通用方法
     * @param type
     */
    public void doRequest(String type) {
        Subject subject = createSubject(type);
        subject.request();
    }
}
