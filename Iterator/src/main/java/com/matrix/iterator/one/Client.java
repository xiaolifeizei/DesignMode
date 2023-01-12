package com.matrix.iterator.one;

/**
 * 客户端角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 09:12
 */
public class Client {

    public static void main(String[] args) {
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("1");
        aggregate.add("2");
        aggregate.add("3");
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
