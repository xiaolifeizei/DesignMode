package com.matrix.command.one;

/**
 * 具体命令角色1
 * 接收者1(ReceiverFirst)的executeOne命令
 *
 * @author : cui_feng
 * @since : 2023-01-11 11:58
 */
public class ConcreteCommandReceiverFirstTwo implements Command {

    private final ReceiverFirst receiver;

    public ConcreteCommandReceiverFirstTwo(ReceiverFirst receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.executeTwo();
    }

    @Override
    public void undo() {
        System.out.println("ReceiverFirst executeTwo undo....");
    }

    @Override
    public ConcreteCommandReceiverFirstTwo clone() {
        try {
            return (ConcreteCommandReceiverFirstTwo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
