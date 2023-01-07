package com.matrix.builder.two;

import lombok.Getter;

/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:39
 */
public class Subject {

    @Getter
    private final String partOne;

    @Getter
    private final Long partTwo;

    private Subject(SubjectBuilder subjectBuilder) {
        this.partOne = subjectBuilder.partOne;
        this.partTwo = subjectBuilder.partTwo;
    }

    public void show() {
        System.out.println("partOne: " + partOne);
        System.out.println("partTwo: " + partTwo);
    }


    public static class SubjectBuilder {

        private String partOne;
        private Long partTwo;

        public SubjectBuilder setPartOne(String partOne) {
            if (partOne == null) {
                throw new IllegalArgumentException("partOne must not null");
            }
            this.partOne = partOne;
            return this;
        }

        public SubjectBuilder setPartTwo(Long partTwo) {
            if (partTwo < 0 || partTwo > 99999) {
                throw new IllegalArgumentException("partTwo must be no less than zero and no more than 99999");
            }
            this.partTwo = partTwo;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
