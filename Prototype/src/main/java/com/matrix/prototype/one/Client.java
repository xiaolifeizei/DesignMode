package com.matrix.prototype.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 12:45
 */
public class Client {

    public static void main(String[] args) {
        Subject partOne = new Subject();
        Subject subject1 = new Subject(partOne);
        Subject subject2 = subject1.clone();

        // 不相等，clone()后是不同的对象
        System.out.println(subject1 == subject2);
        // 相等，浅拷贝
        System.out.println(subject1.getPartOne() == subject2.getPartOne());

        System.out.println("===================================================");

        SubjectDeepClone deepPartOne = new SubjectDeepClone();
        SubjectDeepClone subjectDeepClone1 = new SubjectDeepClone(deepPartOne);
        SubjectDeepClone subjectDeepClone2 = subjectDeepClone1.clone();

        // 不相等，clone()后是不同的对象
        System.out.println(subjectDeepClone1 == subjectDeepClone2);
        // 不相等，clone()时进行了深拷贝
        System.out.println(subjectDeepClone1.getPartOne() == subjectDeepClone2.getPartOne());

        System.out.println("===================================================");

        SubjectSerializableDeepClone serializablePartOne = new SubjectSerializableDeepClone();
        SubjectSerializableDeepClone subjectSerializableDeepClone1 = new SubjectSerializableDeepClone(serializablePartOne);
        SubjectSerializableDeepClone subjectSerializableDeepClone2 = subjectSerializableDeepClone1.clone();

        // 不相等，clone()使用Serializable生成新的对象
        System.out.println(subjectSerializableDeepClone1 == subjectSerializableDeepClone2);
        // 不相等
        System.out.println(subjectSerializableDeepClone1.getPartOne() == subjectSerializableDeepClone2.getPartOne());
    }
}
