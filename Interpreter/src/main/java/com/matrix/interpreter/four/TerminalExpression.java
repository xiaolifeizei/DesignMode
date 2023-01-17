package com.matrix.interpreter.four;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : cui_feng
 * @since : 2023-01-17 08:39
 */
public class TerminalExpression implements Expression{

    private final Set<String> set =new HashSet<>();

    public TerminalExpression(String[] data) {
        Collections.addAll(set, data);
    }


    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}
