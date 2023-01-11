package com.matrix.command.three;

/**
 * @author : cui_feng
 * @since : 2023-01-11 17:08
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    protected abstract void execute();
}
