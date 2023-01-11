package com.matrix.command.three;

import lombok.Getter;

/**
 * @author : cui_feng
 * @since : 2023-01-11 17:22
 */
public abstract class Receiver {

    @Getter
    private boolean running = false;

    @Getter
    private final String name;

    public Receiver(String name) {
        this.name = name;
    }

    void start() {
        if (running) {
            System.out.println(this.name + " is running....");
        } else {
            System.out.println(this.name + " start....");
            running = true;
        }
    }

    public void stop() {
        if (running) {
            System.out.println(this.name + " stop....");
            running = false;
        } else {
            System.out.println(this.name + " is not running....");
        }
    }

    public void showState() {
        System.out.println(this.name + " is " + (running ? "running" : "not running") + "....");
    }

    public abstract void doWork();
}
