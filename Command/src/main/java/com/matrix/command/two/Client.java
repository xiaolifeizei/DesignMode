package com.matrix.command.two;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-11 13:55
 */
public class Client {

    public static void main(String[] args) {
        Command one = new ConcreteCommandOne();
        Command two =new ConcreteCommandTwo();

        Invoker invoker = new Invoker();
        invoker.print(one);
        invoker.print(two);

        invoker.print(new Command() {
            @Override
            public void execute() {
                System.out.println("anonymous class show....");
            }
        });

        invoker.print(() -> {
            System.out.println("lambda show....");
        });
    }
}
