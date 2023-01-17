package com.matrix.interpreter.four;

/**
 * @author : cui_feng
 * @since : 2023-01-17 08:41
 */
public class NonTerminalExpression implements Expression{
    private final Expression address;
    private final Expression name;
    private final Expression id;

    public NonTerminalExpression(Expression address, Expression name, Expression id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }


    @Override
    public boolean interpret(String info) {
        String[] s =info.split("-");
        return address.interpret(s[0])&&name.interpret(s[1])&&id.interpret(s[2]);
    }
}
