package com.matrix.wrapper.three;


/**
 * 构件1
 *
 * @author : cui_feng
 * @since : 2023-01-09 16:00
 */
public class ConcreteComponentOne extends Component {

    public ConcreteComponentOne() {
        super("one");
    }

    @Override
    public void request() {
        System.out.println("one request....");
    }
}
