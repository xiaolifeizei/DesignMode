package com.matrix.adapter.interfaceadapter;

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:27
 */
public class Client {

    // 只需要方法三
    private static void todoThree(Target target) {
        target.methodThree();
    }

    // 只需要方法二
    private static void todoTwo(Target target) {
        target.methodTwo();
    }

    public static void main(String[] args) {

        // 使用传统方式
        todoThree(new Target() {
            @Override
            public void methodOne() {
            }
            @Override
            public void methodTwo() {
            }
            @Override
            public void methodThree() {
                System.out.println("do methodThree....");
            }

            @Override
            public void methodFour() {
            }
        });

        todoTwo(new Target() {
            @Override
            public void methodOne() {
            }
            @Override
            public void methodTwo() {
                System.out.println("do methodTwo....");
            }
            @Override
            public void methodThree() {
            }
            @Override
            public void methodFour() {
            }
        });

        System.out.println("=============================================");

        // 使用接口适配器
        todoThree(new InterfaceAdapter() {
            @Override
            public void methodThree() {
                System.out.println("do methodThree....");
            }
        });

        todoTwo(new InterfaceAdapter(){
            @Override
            public void methodTwo() {
                System.out.println("do methodTwo....");
            }
        });
    }
}
