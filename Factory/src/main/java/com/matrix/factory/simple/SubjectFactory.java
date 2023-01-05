package com.matrix.factory.simple;

/**
 * 简单工厂类
 * 优点：工厂类负责所有Subject对象的创建，客户端在需要创建对象时，告诉工厂需要哪种类型，工厂只负责创建
 * 缺点：所有类型的对象集中在一个工厂中创建，当Subject对象出现新的类型以及类型结构变得复杂时，工厂就会混乱
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:01
 */
public class SubjectFactory {

    public static Subject createSubject(String type) {
        switch (type) {
            case "one":
                return new SubjectOneImpl();
            case "two":
                return new SubjectTwoImpl();
            case "three":
                return new SubjectThreeImpl();
            default:
                return null;
        }
    }
}
