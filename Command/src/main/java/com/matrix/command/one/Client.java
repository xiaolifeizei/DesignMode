package com.matrix.command.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-11 13:12
 */
public class Client {

    public static void main(String[] args) {
        ReceiverFirst first = new ReceiverFirst();
        ReceiverSecond second = new ReceiverSecond();

        Invoker firstInvoker = new Invoker(first);
        Invoker secondInvoker = new Invoker(second);

        firstInvoker.executeOne();
        firstInvoker.executeTwo();
        firstInvoker.executeTwo();
        firstInvoker.executeOne();

        firstInvoker.undo();
        firstInvoker.executeTwo();
        firstInvoker.undoAll();

        System.out.println("=========================================");

        secondInvoker.executeTwo();
        secondInvoker.executeTwo();
        secondInvoker.executeOne();
        secondInvoker.executeOne();

        secondInvoker.undo();
        secondInvoker.executeTwo();
        secondInvoker.undoAll();

    }
}
