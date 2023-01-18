package com.matrix.abstractfactory;

/**
 * 工厂接口
 * 将SubjectFirst和SubjectSecond放在了一起组成一个新的类别
 *
 * @author : cui_feng
 * @since : 2023-01-06 10:33
 */
public interface SubjectFactory {

    SubjectFirst getSubjectFirst(String type);

    SubjectSecond getSubjectSecond(String type);
}
