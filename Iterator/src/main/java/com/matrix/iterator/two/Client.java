package com.matrix.iterator.two;

/**
 * @author : cui_feng
 * @since : 2023-01-12 10:11
 */
public class Client {

    public static void main(String[] args) {
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("t1");
        aggregate.add("t2");
        aggregate.add("t3");

        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        new ConcreteIterator<>(null);
    }
}
