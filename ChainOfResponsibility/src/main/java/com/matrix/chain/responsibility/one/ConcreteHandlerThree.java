package com.matrix.chain.responsibility.one;

/**
 * 具体处理者3
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:28
 */
public class ConcreteHandlerThree extends AbstractHandler{

    private int play(){
        return 95;
    }

    public int handler(){
        System.out.println("第三关-->ThirdPassHandler");
        int score = play();
        if(score >= 95){
            //分数>=95 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}
