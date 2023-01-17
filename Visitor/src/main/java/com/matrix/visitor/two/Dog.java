package com.matrix.visitor.two;

/**
 * @author : cui_feng
 * @since : 2023-01-17 17:02
 */
public class Dog extends Animal {


    @Override
    public void accept(Execute execute) {
        execute.execute(this);
    }
}
