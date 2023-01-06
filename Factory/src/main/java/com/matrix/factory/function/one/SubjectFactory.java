package com.matrix.factory.function.one;

/**
 * 工厂父类
 * 1、定义了创建对象的接口：getSubject(String type);
 * 2、由子类决定实例化
 * 3、子类创建过程中调用父类通用接口
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:32
 */
public abstract class SubjectFactory {

    /**
     * 创建对象放到子类
     * @return SubjectFirst
     */
    public abstract Subject getSubject();

    /**
     * 通用方法
     */
    protected void beforeCreate() {
        System.out.println("before create subject....");
    }

    /**
     * 通用方法
     */
    protected void afterCreate() {
        System.out.println("after create subject....");
    }
}
