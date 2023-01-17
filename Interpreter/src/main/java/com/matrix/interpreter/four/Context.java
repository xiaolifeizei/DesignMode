package com.matrix.interpreter.four;

/**
 * @author : cui_feng
 * @since : 2023-01-17 08:43
 */
public class Context {

    private final Expression infomation;

    public Context()
    {
        String[] shuzis = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        Expression shuzi=new TerminalExpression(shuzis);
        String[] xiaoxiezimus = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
        Expression xiaoxiezimu=new TerminalExpression(xiaoxiezimus);
        String[] daxiezimus = {"A", "B", "C", "D", "E", "F", "G"};
        Expression daxiezimu=new TerminalExpression(daxiezimus);
        infomation = new NonTerminalExpression(shuzi,xiaoxiezimu,daxiezimu);
    }

    public void jieshi(String info)
    {
        boolean ok=infomation.interpret(info);
        if(ok) System.out.println("正确！ ["+info+"] 满足  [单个数字-单个小写-单个大写]  的条件");
        else System.out.println("错误！ ["+info+"] 不满足  [单个数字-单个小写-单个大写]  的条件");
    }
}
