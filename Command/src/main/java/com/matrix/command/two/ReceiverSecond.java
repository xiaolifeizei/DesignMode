package com.matrix.command.two;

/**
 * 接收者1
 * 接收者角色，真正执行命令的具体类
 *
 * @author : cui_feng
 * @since : 2023-01-11 11:53
 */
public class ReceiverSecond implements Receiver{

    @Override
    public void show() {
        System.out.println("ReceiverSecond show....");
    }
}
