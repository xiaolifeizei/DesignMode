package com.matrix.facade.two;

/**
 * 外观角色二
 *
 * @author : cui_feng
 * @since : 2023-01-10 15:42
 */
public class FacadeSecond implements Facade{

    private final SubSystemOne subSystemOne = new SubSystemOne();

    private final SubSystemTwo subSystemTwo = new SubSystemTwo();

    private final SubSystemThree subSystemThree = new SubSystemThree();


    @Override
    public void request() {
        subSystemOne.stepOne();
        subSystemTwo.stepThree();
        subSystemThree.stepTwo();
    }
}
