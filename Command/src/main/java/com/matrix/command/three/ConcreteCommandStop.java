package com.matrix.command.three;

/**
 * start命令
 *
 * @author : cui_feng
 * @since : 2023-01-11 17:29
 */
public class ConcreteCommandStop extends Command{

    public ConcreteCommandStop(Receiver receiver) {
        super(receiver);
    }

    @Override
    protected void execute() {
        receiver.stop();
    }
}
