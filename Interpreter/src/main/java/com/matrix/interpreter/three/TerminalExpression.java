package com.matrix.interpreter.three;

/**
 * @author : cui_feng
 * @since : 2023-01-16 18:02
 */
public class TerminalExpression implements Expression {
    private String message;

    public TerminalExpression(String message) {
        this.message = message;
    }

    @Override
    public boolean interpret(String context) {
        if (context.equals(message)) {
            return true;
        } else {
            return false;
        }
    }
}
