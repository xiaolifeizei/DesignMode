package com.matrix.command.one;

/**
 * 具体命令角色1
 * 接收者1(ReceiverFirst)的executeOne命令
 *
 * @author : cui_feng
 * @since : 2023-01-11 11:58
 */
public class ConcreteCommandReceiverSecondOne implements Command {

    private final ReceiverSecond receiver;

    public ConcreteCommandReceiverSecondOne(ReceiverSecond receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.executeOne();
    }

    @Override
    public void undo() {
        System.out.println("ReceiverSecond executeOne undo....");
    }

    @Override
    public ConcreteCommandReceiverSecondOne clone() {
        try {
            return (ConcreteCommandReceiverSecondOne) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
