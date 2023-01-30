package com.matrix.chain.responsibility.one;

/**
 * 具体处理者1
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:28
 */
public class ConcreteHandlerOne extends AbstractHandler{

    private int play(){
        return 80;
    }

    @Override
    public int handler() {
        System.out.println("第一关-->FirstPassHandler");
        int score = play();
        if(score >= 80){
            //分数>=80 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}
