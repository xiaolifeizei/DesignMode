package com.matrix.dm.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Cglib动态代理
 * 功能强大，不需要接口就可以生成代理类
 * 使用jdk8的时候，jdk代理效率高于CGLIB 代理
 *
 * @author : cui_feng
 * @since : 2023-01-05 13:54
 */
public class Client {

    public static void main(String[] args) {
        // 增强者
        Enhancer enhancer = new Enhancer();
        // 指定父类
        enhancer.setSuperclass(Subject.class);
        // 当被代理对象的方法调用的时候会被拦截
        // final，static方法不会拦截
        enhancer.setCallback(new SubjectInterceptor());
        // 生成动态代理类
        Subject subjectProxy = (Subject) enhancer.create();
        subjectProxy.request();
        subjectProxy.response();
        subjectProxy.testFinal();
        Subject.testStatic();
    }
}
