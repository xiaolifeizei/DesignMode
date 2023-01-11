package com.matrix.command.one;

/**
 * 命令角色
 * 为了实现撤销操作需要实现Cloneable接口
 *
 * @author : cui_feng
 * @since : 2023-01-11 11:52
 */
public interface Command extends Cloneable{

    void execute();

    void undo();

    Command clone();
}
