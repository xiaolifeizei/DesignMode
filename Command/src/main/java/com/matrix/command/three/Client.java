package com.matrix.command.three;

/**
 * @author : cui_feng
 * @since : 2023-01-11 17:32
 */
public class Client {

    public static void main(String[] args) {
        Receiver one = new ReceiverOne();
        Receiver two = new ReceiverTwo();

        Invoker invoker = new Invoker(one);

        invoker.start();
        invoker.doWork();
        invoker.stop();
        invoker.show();

        System.out.println("========================================");

        invoker.setReceiver(two);
        invoker.start();
        invoker.doWork();
        invoker.show();
        invoker.stop();

        System.out.println("========================================");

        Invoker.execute(new ConcreteCommandStart(one));
        Invoker.execute(new ConcreteCommandDoWork(one));
        Invoker.execute(new ConcreteCommandShowState(one));
        Invoker.execute(new ConcreteCommandStop(one));

        System.out.println("========================================");

        Invoker.execute(new ConcreteCommandStart(two));
        Invoker.execute(new ConcreteCommandDoWork(two));
        Invoker.execute(new ConcreteCommandStop(two));
        Invoker.execute(new ConcreteCommandShowState(two));
    }
}
