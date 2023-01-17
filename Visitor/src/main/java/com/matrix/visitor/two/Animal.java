package com.matrix.visitor.two;

/**
 * @author : cui_feng
 * @since : 2023-01-17 17:01
 */
public class Animal {

    public void accept(Execute execute) {
        execute.execute(this);
    }
}
