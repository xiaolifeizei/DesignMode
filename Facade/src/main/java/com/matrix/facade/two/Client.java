package com.matrix.facade.two;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-10 15:55
 */
public class Client {

    public static void main(String[] args) {
        Facade facadeFirst = new FacadeFirst();
        facadeFirst.request();

        System.out.println("===============================");

        Facade facadeSecond = new FacadeSecond();
        facadeSecond.request();
    }
}
