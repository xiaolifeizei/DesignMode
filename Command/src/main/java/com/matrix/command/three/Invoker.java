package com.matrix.command.three;

/**
 * @author : cui_feng
 * @since : 2023-01-11 17:31
 */
public class Invoker {

    private Command cmd_start;
    private Command cmd_stop;
    private Command cmd_show;
    private Command cmd_work;

    public Invoker(Receiver receiver) {
        setReceiver(receiver);
    }

    public void setReceiver(Receiver receiver) {
        cmd_start = new ConcreteCommandStart(receiver);
        cmd_stop = new ConcreteCommandStop(receiver);
        cmd_show = new ConcreteCommandShowState(receiver);
        cmd_work = new ConcreteCommandDoWork(receiver);
    }

    public static void execute(Command command) {
        command.execute();
    }

    public void start() {
        cmd_start.execute();
    }

    public void stop() {
        cmd_stop.execute();
    }

    public void show() {
        cmd_show.execute();
    }

    public void doWork() {
        cmd_work.execute();
    }
}
