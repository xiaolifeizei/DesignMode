package com.matrix.templatemethod.two;

/**
 * 具体子类1
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:51
 */
public class ConcreteClassThree extends AbstractClass {

    public ConcreteClassThree() {
    }

    @Override
    protected void showStepOne() {
        System.out.println("ConcreteClassThree step one....");
    }

    @Override
    protected void showStepTwo() {
        System.out.println("ConcreteClassThree step two....");
    }

    @Override
    protected boolean isStepThree() {
        return false;
    }
}
