package com.matrix.builder.three;

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

    @Getter
    private final String partThree;

    private Subject(SubjectBuilder subjectBuilder) {
        this.partOne = subjectBuilder.partOne;
        this.partTwo = subjectBuilder.partTwo;
        this.partThree = subjectBuilder.partThree;
    }

    public void show() {
        System.out.println("partOne: " + partOne);
        System.out.println("partTwo: " + partTwo);
        System.out.println("partThree: " + partThree);
    }

    static abstract class SubjectBuilder {
        protected String partOne;
        protected Long partTwo;

        protected String partThree;

        public Subject build() {
            return new Subject(this);
        }
    }

    public static class SubjectOneBuilder extends SubjectBuilder {

        public SubjectOneBuilder() {
            super.partThree = "SubjectOne";
        }

        public SubjectOneBuilder setPartOne(String partOne) {
            if (partOne == null) {
                throw new IllegalArgumentException("partOne must not null");
            }
            super.partOne = partOne;
            return this;
        }

        public SubjectOneBuilder setPartTwo(Long partTwo) {
            if (partTwo < 0 || partTwo > 99999) {
                throw new IllegalArgumentException("partTwo must be no less than zero and no more than 99999");
            }
            super.partTwo = partTwo;
            return this;
        }
    }

    public static class SubjectTwoBuilder extends SubjectBuilder {

        public SubjectTwoBuilder() {
            super.partThree = "SubjectTwo";
        }

        public SubjectTwoBuilder setPartOne(String partOne) {
            if (partOne == null) {
                throw new IllegalArgumentException("partOne must not null");
            }
            super.partOne = partOne;
            return this;
        }

        public SubjectTwoBuilder setPartTwo(Long partTwo) {
            if (partTwo < 0 || partTwo > 99999) {
                throw new IllegalArgumentException("partTwo must be no less than zero and no more than 99999");
            }
            super.partTwo = partTwo;
            return this;
        }
    }
}
