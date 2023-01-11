package com.matrix.command.two;

/**
 * 请求者角色
 *
 * @author : cui_feng
 * @since : 2023-01-11 12:38
 */
public class Invoker{

    public void print(Command command) {
        command.execute();
    }
}
