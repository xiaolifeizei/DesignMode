package com.matrix.builder.four;


/**
 * 建造者基类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:47
 */
public abstract class SubjectBuilder {

    protected String partOne;

    protected Long partTwo;

    private String partThree;

    public abstract void buildPartOne();

    public abstract void buildPartTwo();

    public void buildPartThree(String partThree) {
        this.partThree = partThree;
    }

    /**
     * 这种方式每个builder都可以创建出不同的subject
     * @return Subject实例
     */
    public Subject getSubject() {
        return new Subject(partOne, partTwo, partThree);
    }
}
