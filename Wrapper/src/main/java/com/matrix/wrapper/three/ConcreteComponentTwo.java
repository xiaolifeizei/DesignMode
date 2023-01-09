package com.matrix.wrapper.three;


/**
 * 构件2
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:00
 */
public class ConcreteComponentTwo extends Component {

    public ConcreteComponentTwo() {
        super("two");
    }

    @Override
    public void request() {
        System.out.println("two request....");
    }
}
