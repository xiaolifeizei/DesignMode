package com.matrix.composite.two;


/**
 * 使用
 *  对于合成模式而言，在安全性和透明性上，会更看重透明性，毕竟合成模式的目的
 *  是让客户端不再区分操作的是树枝对象还是树叶对象，而是以一个统一的方式来操作。
 *  而且对于安全性的实现，需要区分是树枝对象还是树叶对象。
 *  有时候，需要将对象进行类型转换，却发现类型信息丢失了，只好强行转换，这种类型转换必然是不够安全的。
 *  因此在使用合成模式的时候，建议多采用透明性的实现方式。　
 *
 * @author : cui_feng
 * @since : 2023-01-10 13:22
 */
public class Client {

    public static void main(String[] args) {
        Component root = new Composite("服装");
        Component c1 = new Composite("男装");
        Component c2 = new Composite("女装");
        Component c3 = new Composite("夹克");

        Component leaf1 = new Leaf("衬衫");
        Component leaf2 = new Leaf("真皮夹克");
        Component leaf3 = new Leaf("裙子");
        Component leaf4 = new Leaf("套装");
        Component leaf5 = new Leaf("PU夹克");
        Component leaf6 = new Leaf("冲锋衣");



        root.addChildren(c1);
        root.addChildren(c2);


        c1.addChildren(leaf1);
        c1.addChildren(c3);
        c1.addChildren(leaf6);

        c2.addChildren(leaf3);
        c2.addChildren(leaf4);

        c3.addChildren(leaf2);
        c3.addChildren(leaf5);

        root.show();

    }
}
