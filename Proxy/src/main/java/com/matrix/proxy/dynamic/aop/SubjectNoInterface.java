package com.matrix.proxy.dynamic.aop;

import org.springframework.stereotype.Component;

/**
 * 被代理对象不继承接口
 *
 * @author : cui_feng
 * @since : 2023-01-05 15:30
 */
@Component
public class SubjectNoInterface {

    public void request(){
        System.out.println("doing request....");
    }

    public void response() {
        System.out.println("doing response....");
    }

    public final void testFinal() {
        System.out.println("doing testFinal....");
    }
}
