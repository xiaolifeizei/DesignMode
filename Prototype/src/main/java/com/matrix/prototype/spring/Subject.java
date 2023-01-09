package com.matrix.prototype.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : cui_feng
 * @since : 2023-01-09 13:19
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class Subject {

    private String partOne;

    private Long partTwo;
}
