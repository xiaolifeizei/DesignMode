package com.matrix.factory.function;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:42
 */
public class Client {

    public static void main(String[] args) {
        ServiceOne s1 = new ServiceOne();
        s1.doRequest("one");
        s1.doRequest("two");
        s1.doRequest("three");
        System.out.println("---------------------------------");

        ServiceTwo s2 = new ServiceTwo();
        s2.doRequest("one");
        s2.doRequest("two");
        s2.doRequest("three");
        System.out.println("---------------------------------");

        ServiceThree s3 = new ServiceThree();
        s3.doRequest("one");
        s3.doRequest("two");
        s3.doRequest("three");
    }
}
