package com.matrix.prototype.one;

import lombok.Data;

/**
 * 深拷贝
 *
 * @author : cui_feng
 * @since : 2023-01-07 12:58
 */
@Data
public class SubjectDeepClone implements Cloneable{

    private SubjectDeepClone partOne;

    public SubjectDeepClone() {

    }

    public SubjectDeepClone(SubjectDeepClone partOne) {
        this.partOne = partOne;
    }

    @Override
    protected SubjectDeepClone clone() {
        try {
            SubjectDeepClone subjectDeepClone = (SubjectDeepClone) super.clone();
            // 单独处理引用类型实现深拷贝
            if (partOne != null) {
                partOne = (SubjectDeepClone) partOne.clone();
            }
            return subjectDeepClone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
