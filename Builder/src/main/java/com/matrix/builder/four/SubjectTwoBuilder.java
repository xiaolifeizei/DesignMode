package com.matrix.builder.four;

/**
 * @author : cui_feng
 * @since : 2023-01-07 11:37
 */
public class SubjectTwoBuilder extends SubjectBuilder{
    @Override
    public void buildPartOne() {
        partOne = "SubjectTwo partOne";
    }

    @Override
    public void buildPartTwo() {
        partTwo = 2L;
    }
}
