package com.matrix.visitor.two;

/**
 * @author : cui_feng
 * @since : 2023-01-17 17:03
 */
public class Execute {

    public void execute(Animal a) {
        System.out.println("animal");
    }
    public void execute(Dog d) {
        System.out.println("dog");
    }
    public void execute(Cat c) {
        System.out.println("cat");
    }
}
