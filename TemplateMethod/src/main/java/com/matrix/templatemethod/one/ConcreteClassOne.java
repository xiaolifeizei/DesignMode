package com.matrix.templatemethod.one;

/**
 * 具体子类1
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:51
 */
public class ConcreteClassOne extends AbstractClass{

    @Override
    protected void showStepOne() {
        System.out.println("ConcreteClassOne step one....");
    }

    @Override
    protected void showStepTwo() {
        System.out.println("ConcreteClassOne step two....");
    }
}
