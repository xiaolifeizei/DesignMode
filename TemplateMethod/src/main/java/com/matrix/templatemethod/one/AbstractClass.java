package com.matrix.templatemethod.one;

/**
 * 抽象类
 *
 * @author : cui_feng
 * @since : 2023-01-11 10:46
 */
public abstract class AbstractClass {

    /**
     * 抽象方法
     */
    protected abstract void showStepOne();

    /**
     * 抽象方法
     */
    protected abstract void showStepTwo();

    /**
     * 具体方法
     */
    protected void showStepThree() {
        System.out.println("show StepThree....");
    }

    /**
     * 模板方法
     */
    public final void show() {
        showStepOne();
        showStepTwo();
        showStepThree();
        System.out.println("show finish....");
    }
}
