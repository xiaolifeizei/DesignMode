package com.matrix.state.lift;

/**
 * @author : cui_feng
 * @since : 2023-01-17 11:26
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
