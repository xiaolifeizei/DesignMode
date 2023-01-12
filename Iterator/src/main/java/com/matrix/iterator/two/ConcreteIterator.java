package com.matrix.iterator.two;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * 迭代器，倒排
 *
 * @author : cui_feng
 * @since : 2023-01-12 10:06
 */
public class ConcreteIterator<E> implements Iterator<E> {

    private final List<E> list;

    private int index;

    public ConcreteIterator(@NotNull List<E> list) {
        this.list = list;
        index = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return list != null && !list.isEmpty() && index >= 0;
    }

    @Override
    public E next() {
        return list == null || list.isEmpty() ? null : list.get(index--);
    }
}
