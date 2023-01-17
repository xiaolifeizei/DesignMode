package com.matrix.visitor.one;

/**
 * 使用
 * @author : cui_feng
 * @since : 2023-01-17 16:40
 */
public class Client {

    public static void main(String[] args) {
        // 创建结构对象
        ObjectStructure os = new ObjectStructure();
        // 增加节点
        os.add(new ElementFirst());
        os.add(new ElementSecond());


        //创建访问者
        Visitor visitor = new ConcreteVisitorOne();
        os.action(visitor);

        visitor = new ConcreteVisitorTwo();
        os.action(visitor);
    }
}
