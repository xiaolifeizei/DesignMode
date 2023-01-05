package com.matrix.dm.dynamic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 *
 * @author : cui_feng
 * @since : 2023-01-05 14:25
 */
@Aspect
@Component
public class SubjectAspect {

    /**
     * 切接口，默认使用jdk动态代理
     *      如果指定了proxyTargetClass=“true”
     *      则强制使用cglib
     */
    @Pointcut("execution(* com.matrix.dm.dynamic.aop.Subject.*(..))")
    private void pointcutInterface() {}

    /**
     * 切类，使用cglib生成代理
     */
    @Pointcut("execution(* com.matrix.dm.dynamic.aop.SubjectNoInterface.*(..))")
    private void pointcutClass() {};


    @Before("pointcutInterface()")
    public void beforeInterface(JoinPoint joinPoint){
        System.out.println("before " + joinPoint.getSignature().getName());
    }

    @After("pointcutInterface()")
    public void afterInterface(JoinPoint joinPoint){
        System.out.println("after " + joinPoint.getSignature().getName());
    }

    @Before("pointcutClass()")
    public void beforeClass(JoinPoint joinPoint){
        System.out.println("before " + joinPoint.getSignature().getName());
    }

    @After("pointcutClass()")
    public void afterClass(JoinPoint joinPoint){
        System.out.println("after " + joinPoint.getSignature().getName());
    }
}
