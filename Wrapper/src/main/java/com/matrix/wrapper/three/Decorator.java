package com.matrix.wrapper.three;


import lombok.Getter;

/**
 * 装饰器抽象类
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:01
 */
public abstract class Decorator extends Component {

    @Getter
    private final Component component;

    public Decorator(Component component,String name) {
        super(name);
        this.component = component;
    }

    public String getNames() {
        String componentName = "";
        if (component instanceof Decorator) {
            componentName = ((Decorator) component).getNames() + " " + componentName;
            return componentName.trim() + " " + getName();
        }

        return component.getName() + " " + getName();
    }

    public abstract void request();
}
