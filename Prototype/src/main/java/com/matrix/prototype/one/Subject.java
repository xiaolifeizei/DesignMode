package com.matrix.prototype.one;

import lombok.Data;

/**
 * Subject抽象基类
 *
 * @author : cui_feng
 * @since : 2023-01-07 12:18
 */
@Data
public class Subject implements Cloneable{

    private Subject partOne;

    public Subject() {

    }

    public Subject(Subject partOne) {
        this.partOne = partOne;
    }

    @Override
    protected Subject clone() {
        try {
            return (Subject) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
