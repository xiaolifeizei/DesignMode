package com.matrix.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理类
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:49
 */
public class SubjectHandler implements InvocationHandler {

    private final Object target;

    public SubjectHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before "+ method.getName() +"....");
        Object result = method.invoke(target, args);
        System.out.println("after " + method.getName() + "....");
        return result;
    }
}
