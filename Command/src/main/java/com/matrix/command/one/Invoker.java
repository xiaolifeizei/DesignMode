package com.matrix.command.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 请求者角色
 * 要求命令对象执行请求，通常会持有命令对象，可以持有很多的命令对象
 * 这个是客户端真正触发命令并要求命令执行相应操作的地方，相当于使用命令对象的入口
 *
 * @author : cui_feng
 * @since : 2023-01-11 12:38
 */
public class Invoker {

    private Command firstOne = null;

    private Command firstTwo = null;

    private Command secondOne = null;

    private Command secondTwo = null;

    private final List<Command> firstUndoList = new ArrayList<>();

    private final List<Command> secondUndoList = new ArrayList<>();

    private boolean isOne = false;

    public Invoker(ReceiverFirst receiver) {
        this.firstOne = new ConcreteCommandReceiverFirstOne(receiver);
        this.firstTwo = new ConcreteCommandReceiverFirstTwo(receiver);
        this.isOne = true;
    }

    public Invoker(ReceiverSecond receiver) {
        this.secondOne = new ConcreteCommandReceiverSecondOne(receiver);
        this.secondTwo = new ConcreteCommandReceiverSecondTwo(receiver);
    }

    public void executeOne() {
        if (isOne) {
            firstOne.execute();
            firstUndoList.add(this.firstOne.clone());
        } else {
            secondOne.execute();
            secondUndoList.add(this.secondOne.clone());
        }
    }

    public void executeTwo() {
        if (isOne) {
            firstTwo.execute();
            firstUndoList.add(this.firstTwo.clone());
        } else {
            secondTwo.execute();
            secondUndoList.add(this.secondTwo.clone());
        }
    }

    /**
     * 撤销上一步
     */
    public void undo() {
        if (isOne && firstUndoList.size() > 0) {
            Command command = firstUndoList.get(firstUndoList.size() -1);
            command.undo();
            firstUndoList.remove(command);
        } else if (secondUndoList.size() > 0){
            Command command = secondUndoList.get(secondUndoList.size() -1);
            command.undo();
            secondUndoList.remove(command);
        } else {
            System.out.println("还没有执行过任何命令");
        }
    }

    /**
     * 全部撤销
     */
    public void undoAll() {
        if (isOne && firstUndoList.size() > 0) {
            // 将命令列表倒排
            Collections.reverse(firstUndoList);
            firstUndoList.forEach(Command::undo);
            firstUndoList.clear();
        } else if (secondUndoList.size() > 0){
            Collections.reverse(secondUndoList);
            secondUndoList.forEach(Command::undo);
            secondUndoList.clear();
        } else {
            System.out.println("还没有执行过任何命令");
        }
    }
}
