package com.matrix.templatemethod.two;

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
     * 钩子方法（Hook）
     */
    protected boolean isStepThree() {
        return true;
    }

    /**
     * 模板方法
     */
    public final void show() {
        showStepOne();
        showStepTwo();
        // 在流程中使用钩子方法
        if (isStepThree()) {
            showStepThree();
        }
        System.out.println("show finish....");
        System.out.println("======================================");
    }
}
