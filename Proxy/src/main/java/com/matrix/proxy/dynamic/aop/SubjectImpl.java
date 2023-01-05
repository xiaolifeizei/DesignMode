package com.matrix.proxy.dynamic.aop;

import org.springframework.stereotype.Component;

/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-05 12:41
 */
@Component
public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("doing request....");
    }

    @Override
    public void response() {
        System.out.println("doing response....");
    }
}
