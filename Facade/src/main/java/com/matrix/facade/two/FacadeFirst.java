package com.matrix.facade.two;

/**
 * 外观角色一
 *
 * @author : cui_feng
 * @since : 2023-01-10 15:42
 */
public class FacadeFirst implements Facade{
    private final SubSystemOne subSystemOne = new SubSystemOne();

    private final SubSystemTwo subSystemTwo = new SubSystemTwo();

    private final SubSystemThree subSystemThree = new SubSystemThree();


    @Override
    public void request() {
        subSystemTwo.stepOne();
        subSystemOne.stepThree();
        subSystemThree.stepTwo();
    }
}
