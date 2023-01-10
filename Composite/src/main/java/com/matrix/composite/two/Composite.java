package com.matrix.composite.two;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝构件
 *
 * @author : cui_feng
 * @since : 2023-01-10 13:14
 */
public class Composite extends Component {

    @Getter
    private final String name;

    @Getter
    private final List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChildren(Component children){
        this.children.add(children);
    }

    @Override
    public void removeChildren(int index){
        this.children.remove(index);
    }


    @Override
    public void show() {
        System.out.println(this.name);
        show(children, 0);
    }

    private void show(List<Component> children, int index) {
        children.forEach(item -> {
            for (int i = 0; i <= index; i++) {
                System.out.print("--");
            }
            if (item instanceof Composite) {
                Composite temp = ((Composite)item);
                System.out.println(temp.name);
                show(temp.getChildren(),  index + 1);
            } else {
                item.show();
            }
        });
    }
}
