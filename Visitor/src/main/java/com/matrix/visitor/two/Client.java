package com.matrix.visitor.two;

/**
 * @author : cui_feng
 * @since : 2023-01-17 17:05
 */
public class Client {

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();
        Animal c = new Cat();
        Execute exe = new Execute();
        a.accept(exe);
        d.accept(exe);
        c.accept(exe);
    }
}
