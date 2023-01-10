package com.matrix.facade.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-10 15:27
 */
public class Client {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
