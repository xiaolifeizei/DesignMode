package com.matrix.proxy.dynamic.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理
 * 比较灵活，但是必须要有接口才可以生成代理类
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:52
 */
public class Client {

    public static void main(String[] args) {

        // 方式1：编写代理处理器
        SubjectImpl subjectImpl = new SubjectImpl();
        Subject proxyBean  = (Subject) Proxy.newProxyInstance(SubjectImpl.class.getClassLoader(), new Class[] {Subject.class}, new SubjectHandler(subjectImpl));
        proxyBean.request();
        proxyBean.response();

        System.out.println("------------------------------------------------");

        // 方式2：使用lambda
        Subject proxyBean2 = (Subject) Proxy.newProxyInstance(subjectImpl.getClass().getClassLoader(), subjectImpl.getClass().getInterfaces(), (proxy,method,arg) -> {
            System.out.println("before "+ method.getName() +"....");
            Object result = method.invoke(subjectImpl, arg);
            System.out.println("after " + method.getName() + "....");
            return result;
        });
        proxyBean2.request();
        proxyBean2.response();

        System.out.println("------------------------------------------------");

        // 方式3：使用匿名类
        Subject proxyBean3 = (Subject) Proxy.newProxyInstance(subjectImpl.getClass().getClassLoader(), subjectImpl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (!"request".equals(method.getName())) {
                    return method.invoke(subjectImpl, args);
                }
                System.out.println("before " + method.getName() + "....");
                Object result = method.invoke(subjectImpl, args);
                System.out.println("after " + method.getName() + "....");
                return result;
            }
        });
        proxyBean3.request();
        proxyBean3.response();
    }
}
