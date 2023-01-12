package com.matrix.iterator.two;

/**
 * @author : cui_feng
 * @since : 2023-01-12 10:04
 */
public interface Aggregate<E> {

    boolean add(E e);

    boolean remove(E e);

    Iterator<E> iterator();
}
