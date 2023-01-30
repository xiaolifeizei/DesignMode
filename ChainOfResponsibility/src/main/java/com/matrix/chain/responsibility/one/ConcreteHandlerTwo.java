package com.matrix.chain.responsibility.one;

/**
 * 具体处理者2
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:28
 */
public class ConcreteHandlerTwo extends AbstractHandler{

    private int play(){
        return 90;
    }

    public int handler(){
        System.out.println("第二关-->SecondPassHandler");

        int score = play();
        if(score >= 90){
            //分数>=90 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }

        return score;
    }
}
