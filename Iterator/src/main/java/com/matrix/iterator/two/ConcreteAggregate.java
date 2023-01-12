package com.matrix.iterator.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cui_feng
 * @since : 2023-01-12 10:09
 */
public class ConcreteAggregate<E> implements Aggregate<E> {

    private final List<E> list = new ArrayList<>();

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(E e) {
        return list.remove(e);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.list);
    }
}
