package com.matrix.dm.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 *
 * @author : cui_feng
 * @since : 2023-01-05 13:52
 */
public class SubjectInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Class Name："+o.getClass().getName());
        System.out.println("Super Class Name："+o.getClass().getSuperclass().getName());
        System.out.println("before "+ method.getName() + "....");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after " + method.getName() + "....");
        return result;
    }
}
