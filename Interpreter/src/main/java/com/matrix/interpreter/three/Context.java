package com.matrix.interpreter.three;

/**
 * @author : cui_feng
 * @since : 2023-01-16 18:03
 */
public class Context {
    private String brand = "联想";
    private String size = "16寸";
    private Expression expression = null;

    public Context(){
        Expression brand = new TerminalExpression(this.brand);
        Expression size = new TerminalExpression(this.size);
        expression = new AndExpression(brand,size);
    }

    public void result(String context){
        boolean target = expression.interpret(context);
        if(target){
            System.out.println(context + "：是我想要的电脑，买了");
        }else{
            System.out.println(context + ": 不满足我的要求");
        }
    }
}
