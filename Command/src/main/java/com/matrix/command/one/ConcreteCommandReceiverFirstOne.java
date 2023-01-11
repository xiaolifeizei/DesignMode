package com.matrix.command.one;

import lombok.Getter;

/**
 * 具体命令角色1
 * 接收者1(ReceiverFirst)的executeOne命令
 *
 * @author : cui_feng
 * @since : 2023-01-11 11:58
 */
public class ConcreteCommandReceiverFirstOne implements Command {

    private final ReceiverFirst receiver;

    public ConcreteCommandReceiverFirstOne(ReceiverFirst receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.executeOne();
    }

    @Override
    public void undo() {
        System.out.println("ReceiverFirst executeOne undo....");
    }

    @Override
    public ConcreteCommandReceiverFirstOne clone() {
        try {
            return (ConcreteCommandReceiverFirstOne) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
