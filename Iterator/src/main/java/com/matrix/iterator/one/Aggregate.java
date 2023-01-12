package com.matrix.iterator.one;

/**
 * 抽象聚合角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 09:10
 */
public interface Aggregate<E> {

    boolean add(E element);

    boolean remove(E element);

    Iterator<E> iterator();
}
