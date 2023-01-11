package com.matrix.command.two;

/**
 * 具体命令对象
 *
 * @author : cui_feng
 * @since : 2023-01-11 16:06
 */
public class ConcreteCommandTwo implements Command{

    @Override
    public void execute() {
        new ReceiverSecond().show();
    }
}
