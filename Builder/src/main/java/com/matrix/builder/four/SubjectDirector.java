package com.matrix.builder.four;

/**
 * @author : cui_feng
 * @since : 2023-01-07 11:39
 */
public class SubjectDirector {

    private SubjectBuilder subjectBuilder;

    public SubjectDirector(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public void setSubjectBuilder(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public Subject buildSubjectOneFirst() {
        subjectBuilder.buildPartOne();
        subjectBuilder.buildPartTwo();
        subjectBuilder.buildPartThree("build partOne fist");
        return subjectBuilder.getSubject();
    }

    public Subject buildSubjectOneSecond() {
        subjectBuilder.buildPartTwo();
        subjectBuilder.buildPartOne();
        subjectBuilder.buildPartThree("build partTwo fist");
        return subjectBuilder.getSubject();
    }

    public Subject buildSubjectTwoFirst() {
        subjectBuilder.buildPartOne();
        subjectBuilder.buildPartTwo();
        subjectBuilder.buildPartThree("build partOne fist");
        return subjectBuilder.getSubject();
    }

    public Subject buildSubjectTwoSecond() {
        subjectBuilder.buildPartTwo();
        subjectBuilder.buildPartOne();
        subjectBuilder.buildPartThree("build partTwo fist");
        return subjectBuilder.getSubject();
    }
}
