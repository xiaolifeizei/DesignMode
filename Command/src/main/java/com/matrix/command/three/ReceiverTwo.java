package com.matrix.command.three;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : cui_feng
 * @since : 2023-01-11 17:22
 */
public class ReceiverTwo extends Receiver {


    public ReceiverTwo() {
        super("ReceiverTwo");
    }

    @Override
    public void doWork() {
        if (isRunning()) {
            System.out.println(getTimeNow() + " ReceiverTwo is work very hard now!");
        } else {
            System.out.println("ReceiverTwo is not running....");
        }
    }

    private String getTimeNow () {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
}
