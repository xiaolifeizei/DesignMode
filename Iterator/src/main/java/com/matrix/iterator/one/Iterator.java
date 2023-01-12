package com.matrix.iterator.one;

/**
 * 抽象迭代器角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 09:06
 */
public interface Iterator<E> {

    E first();

    E next();

    boolean hasNext();
}
