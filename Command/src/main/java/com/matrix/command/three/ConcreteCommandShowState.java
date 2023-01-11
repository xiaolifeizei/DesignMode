package com.matrix.command.three;

/**
 * start命令
 *
 * @author : cui_feng
 * @since : 2023-01-11 17:29
 */
public class ConcreteCommandShowState extends Command{

    public ConcreteCommandShowState(Receiver receiver) {
        super(receiver);
    }

    @Override
    protected void execute() {
        receiver.showState();
    }
}
