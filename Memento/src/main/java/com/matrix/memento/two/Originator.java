package com.matrix.memento.two;

import lombok.Data;

/**
 * 源发起类
 *
 * @author : cui_feng
 * @since : 2023-01-13 16:27
 */
@Data
public class Originator {

    private String name;

    private Long stamp;

    private String state;

    public Originator(String name) {
        this.name = name;
        this.stamp = System.currentTimeMillis();
    }

    public final Memento save() {
        return new MementoImpl(this);
    }

    public final void recovery(Memento memento) {
        MementoImpl mem = (MementoImpl) memento;
        this.name = mem.getName();
        this.stamp = mem.getStamp();
        this.state = mem.getState();
    }

    /**
     * 窄接口实现
     */
    @Data
    private static class MementoImpl implements Memento {

        private String name;

        private Long stamp;

        private String state;

        private Long saveTime;

        public MementoImpl(Originator originator) {
            this.name = originator.getName();
            this.stamp = originator.getStamp();
            this.state = originator.getState();
            this.saveTime = System.currentTimeMillis();
        }
    }
}
