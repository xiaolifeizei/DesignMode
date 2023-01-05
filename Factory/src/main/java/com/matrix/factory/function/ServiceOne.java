package com.matrix.factory.function;

/**
 * 第一种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class ServiceOne extends AbstractService{
    @Override
    public Subject createSubject(String type) {
        switch (type) {
            case "one":
                System.out.println("ServiceOne create SubjectOne....");
                return new SubjectOneImpl();
            case "two":
                System.out.println("ServiceOne create SubjectTwo....");
                return new SubjectTwoImpl();
            case "three":
                System.out.println("ServiceOne create SubjectThree....");
                return new SubjectThreeImpl();
            default:
                return null;
        }
    }
}
