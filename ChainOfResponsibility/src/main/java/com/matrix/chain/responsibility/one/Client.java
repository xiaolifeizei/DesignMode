package com.matrix.chain.responsibility.one;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:31
 */
public class Client {

    public static void main(String[] args) {
        ConcreteHandlerOne concreteHandlerOne = new ConcreteHandlerOne();//第一关
        ConcreteHandlerTwo concreteHandlerTwo = new ConcreteHandlerTwo();//第二关
        ConcreteHandlerThree concreteHandlerThree = new ConcreteHandlerThree();//第三关

        // 和上面没有更改的客户端代码相比，只有这里的set方法发生变化，其他都是一样的
        concreteHandlerOne.setNext(concreteHandlerTwo);//第一关的下一关是第二关
        concreteHandlerTwo.setNext(concreteHandlerThree);//第二关的下一关是第三关

        //说明：因为第三关是最后一关，因此没有下一关

        //从第一个关卡开始
        concreteHandlerOne.handler();
    }
}
