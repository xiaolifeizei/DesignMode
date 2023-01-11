package com.matrix.command.three;

/**
 * @author : cui_feng
 * @since : 2023-01-11 17:22
 */
public class ReceiverOne extends Receiver {


    public ReceiverOne() {
        super("ReceiverOne");
    }

    @Override
    public void doWork() {
        if (isRunning()) {
            System.out.println("ReceiverOne is work hard!");
        } else {
            System.out.println("ReceiverOne is not running....");
        }
    }
}
