package com.matrix.iterator.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚合角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 09:11
 */
public class ConcreteAggregate<E> implements Aggregate<E>{

    private final List<E> list = new ArrayList<>();

    @Override
    public boolean add(E element) {
        return this.list.add(element);
    }

    @Override
    public boolean remove(E element) {
        return this.list.remove(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.list);
    }
}
