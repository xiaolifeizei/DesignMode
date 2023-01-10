package com.matrix.composite.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-10 13:22
 */
public class Client {

    public static void main(String[] args) {
        Composite root = new Composite("服装");
        Composite c1 = new Composite("男装");
        Composite c2 = new Composite("女装");
        Composite c3 = new Composite("夹克");

        Leaf leaf1 = new Leaf("衬衫");
        Leaf leaf2 = new Leaf("真皮夹克");
        Leaf leaf3 = new Leaf("裙子");
        Leaf leaf4 = new Leaf("套装");
        Leaf leaf5 = new Leaf("PU夹克");
        Leaf leaf6 = new Leaf("冲锋衣");



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
