package com.matrix.visitor.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象
 *
 * @author : cui_feng
 * @since : 2023-01-17 16:39
 */
public class ObjectStructure {

    private final List<Element> elements = new ArrayList<>();

    /**
     * 执行方法操作
     */
    public void action(Visitor visitor){
        for(Element element : elements) {
            element.accept(visitor);
        }
    }
    /**
     * 添加一个新元素
     */
    public void add(Element node){
        elements.add(node);
    }
}
