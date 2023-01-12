package com.matrix.iterator.one;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * 具体迭代器角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 09:07
 */
public class ConcreteIterator<E> implements Iterator<E> {

    private final List<E> list;

    private int index = 0;

    public ConcreteIterator(@NotNull List<E> list) {
        this.list = list;
    }

    @Override
    public E first() {
        E element = null;
        if (this.list != null && !this.list.isEmpty()) {
            element = this.list.get(0);
        }
        return element;
    }

    @Override
    public E next() {
        return this.list.get(this.index++);
    }

    @Override
    public boolean hasNext() {
        return this.list != null && this.index < this.list.size();
    }
}
