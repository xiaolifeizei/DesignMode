package com.matrix.prototype.database;

import lombok.Data;

/**
 * 目标基类
 *
 * @author : cui_feng
 * @since : 2023-01-07 13:17
 */
@Data
public abstract class Subject implements Cloneable {

    private String id;
    private String partOne;

    private Long partTwo;

    @Override
    protected Subject clone() {
        try {
            return (Subject) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void show() {
        System.out.println("Subject " + partOne + " show....");
    }
}
