package com.matrix.prototype.one;

import lombok.Data;

import java.io.*;

/**
 * 使用序列化进行深拷贝
 *
 * @author : cui_feng
 * @since : 2023-01-07 13:06
 */
@Data
public class SubjectSerializableDeepClone implements Serializable {

    private SubjectSerializableDeepClone partOne;

    public SubjectSerializableDeepClone() {

    }

    public SubjectSerializableDeepClone(SubjectSerializableDeepClone partOne) {
        this.partOne = partOne;
    }

    public SubjectSerializableDeepClone clone() {
        try {
            // 将对象写出到流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (SubjectSerializableDeepClone) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
