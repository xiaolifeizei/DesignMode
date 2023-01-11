package com.matrix.templatemethod.two;

/**
 * 具体子类1
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:51
 */
public class ConcreteClassTwo extends AbstractClass {

    @Override
    protected void showStepOne() {
        System.out.println("ConcreteClassTwo step one....");
    }

    @Override
    protected void showStepTwo() {
        System.out.println("ConcreteClassTwo step two....");
    }

    @Override
    protected void showStepThree() {
        System.out.println("ConcreteClassTwo step three....");
    }
}
