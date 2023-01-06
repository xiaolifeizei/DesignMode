package com.matrix.factory.abs;

/**
 * @author : cui_feng
 * @since : 2023-01-06 10:35
 */
public class SubjectCategoryAFactory implements SubjectFactory{

    @Override
    public SubjectFirst getSubjectFirst(String type) {
        if ("one".equals(type)) {
            return new SubjectFirstOneImpl();
        }

        if ("two".equals(type)) {
            return new SubjectFirstTwoImpl();
        }
        return null;
    }

    @Override
    public SubjectSecond getSubjectSecond(String type) {
        if ("one".equals(type)) {
            return new SubjectSecondOneImpl();
        }

        if ("two".equals(type)) {
            return new SubjectSecondTwoImpl();
        }
        return null;
    }
}
