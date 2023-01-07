package com.matrix.builder.one;

import lombok.Data;

/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:39
 */
@Data
public class Subject {

    private String categoryName;

    public void request() {
        System.out.println(categoryName + " subject request....");
    }
}
