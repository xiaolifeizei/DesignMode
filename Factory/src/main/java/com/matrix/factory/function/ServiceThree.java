package com.matrix.factory.function;

/**
 * 第二种服务
 *
 * @author : cui_feng
 * @since : 2023-01-05 17:36
 */
public class ServiceThree extends AbstractService{
    @Override
    public Subject createSubject(String type) {
        switch (type) {
            case "one":
                System.out.println("ServiceThree create SubjectOne....");
                return new SubjectOneImpl();
            case "two":
                System.out.println("ServiceThree create SubjectTwo....");
                return new SubjectTwoImpl();
            case "three":
                System.out.println("ServiceThree create SubjectThree....");
                return new SubjectThreeImpl();
            default:
                return null;
        }
    }
}
