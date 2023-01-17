package com.matrix.interpreter.four;

/**
 * @author : cui_feng
 * @since : 2023-01-17 09:02
 */
public class Client {

    public static void main(String[] args) {
        Context people=new Context();
        people.jieshi("2-a-A");
        people.jieshi("11-A-5");
        people.jieshi("你-好-吖");
        people.jieshi("2aA");
    }
}
