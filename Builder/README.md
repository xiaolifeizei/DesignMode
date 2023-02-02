## 建造者模式（Builder）

建造者模式

### 一、说明

指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。

可以将部件和其组装过程分开，一步一步创建一个复杂的对象。用户只需要指定复杂对象的类型就可以得到该对象，而无须知道其内部的具体构造细节。

### 二、角色

- 产品（Product）角色：

  具体的产品对象，也就是要创建的复杂对象。

- 抽象建造者（Builder）：

  这个接口规定要实现复杂对象（产品）的那些部分的创建，并不涉及具体的部件对象的创建。

- 具体建造者（Concrete Builder）角色：

  实现抽象建造者接口，构建和装配各个部件，在构造过程完成后，提供产品的实例。

- 指挥者（Director）角色：

  调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。它主要有两个作用，一是：隔离了客户与对象的生产过程，二是：负责控制产品对象的生产过程

UML如下

![在这里插入图片描述](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/8d8959486a1c4a3ab346b10c76284a0c.png)

### 三、代码说明

#### 3.1、第一个示例

**1、UML**

![image-20230202102048066](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202102048066.png)

**2、核心代码**

```java
/**
 * 建造者基类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:47
 */
public abstract class SubjectBuilder {

    protected final Subject subject = new Subject();

    public abstract void buildCategoryName();

    /**
     * 这种方式每个builder只能创建一个subject
     */
    public Subject getSubject() {
        return subject;
    }
}

/**
 * A类Subject建造者
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:57
 */
public class SubjectCategoryOneBuilder extends SubjectBuilder{

    @Override
    public void buildCategoryName() {
        subject.setCategoryName("CategoryOne");
    }
}

/**
 * B类Subject建造者
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:57
 */
public class SubjectCategoryTwoBuilder extends SubjectBuilder {
    @Override
    public void buildCategoryName() {
        subject.setCategoryName("CategoryTwo");
    }
}

/**
 * Director，负责组装
 *
 * @author : cui_feng
 * @since : 2023-01-06 16:02
 */
public class SubjectDirector {

    private SubjectBuilder subjectBuilder;

    public SubjectDirector(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public void setSubjectBuilder(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public Subject build() {
        subjectBuilder.buildCategoryName();
        return subjectBuilder.getSubject();
    }
}

/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:39
 */
@Data
public class Subject {

    private String categoryName;

    public void request() {
        System.out.println(categoryName + " subject request....");
    }
}

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 08:44
 */
public class Client {

    public static void main(String[] args) {
        SubjectBuilder subjectOneBuilder = new SubjectCategoryOneBuilder();
        SubjectBuilder subjectTwoBuilder = new SubjectCategoryTwoBuilder();

        SubjectDirector subjectDirector = new SubjectDirector(subjectOneBuilder);

        Subject subjectOne = subjectDirector.build();

        subjectDirector.setSubjectBuilder(subjectTwoBuilder);
        Subject subjectTwo = subjectDirector.build();

        subjectOne.request();
        subjectTwo.request();
    }
}

// ====================================================================================
Connected to the target VM, address: '127.0.0.1:52354', transport: 'socket'
CategoryOne subject request....
CategoryTwo subject request....
Disconnected from the target VM, address: '127.0.0.1:52354', transport: 'socket'
```

#### 3.2、第二个示例

将建造者以静态内部类的形式放到产品中，在源码中经常看到

**1、UML**

![image-20230202102527933](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202102527933.png)

**2、核心代码**

```java
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

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 10:23
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject.SubjectBuilder()
                .setPartOne("aaa")
                .setPartTwo(1001L)
                .build();

        subject.show();
    }
}
```

#### 3.3、第三个示例

与第二个示例一样，只是静态内部类有多个

```java
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

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 10:23
 */
public class Client {

    public static void main(String[] args) {
        Subject subjectOne = new Subject.SubjectOneBuilder()
                .setPartOne("aaa")
                .setPartTwo(1001L)
                .build();

        subjectOne.show();

        Subject subjectTwo = new Subject.SubjectTwoBuilder()
                .setPartOne("bbb")
                .setPartTwo(2002L)
                .build();

        subjectTwo.show();
    }
}
```

#### 3.4、第四个示例

**1、UML**

![image-20230202103601670](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202103601670.png)

**2、核心代码**

```java
/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-06 15:39
 */
@Data
@AllArgsConstructor
public class Subject {

    private String partOne;

    private Long partTwo;

    private String partThree;

    public void show() {
        System.out.println("partOne: " + partOne);
        System.out.println("partTwo: " + partTwo);
        System.out.println("partThree: " + partThree);
    }
}

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

/**
 * @author : cui_feng
 * @since : 2023-01-07 11:37
 */
public class SubjectOneBuilder extends SubjectBuilder{
    @Override
    public void buildPartOne() {
        partOne = "SubjectOne partOne";
    }

    @Override
    public void buildPartTwo() {
        partTwo = 1L;
    }
}

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

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-07 11:44
 */
public class Client {

    public static void main(String[] args) {
        SubjectBuilder subjectBuilderOne = new SubjectOneBuilder();
        SubjectBuilder subjectBuilderTwo = new SubjectTwoBuilder();

        SubjectDirector director = new SubjectDirector(subjectBuilderOne);
        Subject subjectOneFirst = director.buildSubjectOneFirst();
        Subject subjectOneSecond = director.buildSubjectOneSecond();

        director.setSubjectBuilder(subjectBuilderTwo);
        Subject subjectTwoFirst = director.buildSubjectTwoFirst();
        Subject subjectTwoSecond = director.buildSubjectTwoSecond();

        System.out.println("-----------------------------------");
        subjectOneFirst.show();
        System.out.println("-----------------------------------");
        subjectOneSecond.show();

        System.out.println("-----------------------------------");
        subjectTwoFirst.show();
        System.out.println("-----------------------------------");
        subjectTwoSecond.show();

    }
}

// ==================================================================================
Connected to the target VM, address: '127.0.0.1:52537', transport: 'socket'
-----------------------------------
partOne: SubjectOne partOne
partTwo: 1
partThree: build partOne fist
-----------------------------------
partOne: SubjectOne partOne
partTwo: 1
partThree: build partTwo fist
-----------------------------------
partOne: SubjectTwo partOne
partTwo: 2
partThree: build partOne fist
-----------------------------------
partOne: SubjectTwo partOne
partTwo: 2
partThree: build partTwo fist
Disconnected from the target VM, address: '127.0.0.1:52537', transport: 'socket'
```

### 四、总结

#### 1、 与工厂方法模式对比

工厂方法模式注重的是整体对象的创建方式；而建造者模式注重的是部件构建的过程，意在通过一步一步地精确构造创建出一个复杂的对象。

我们举个简单例子来说明两者的差异，如要制造一个超人，如果使用工厂方法模式，直接产生出来的就是一个力大无穷、能够飞翔、内裤外穿的超人；而如果使用建造者模式，则需要组装手、头、脚、躯干等部分，然后再把内裤外穿，于是一个超人就诞生了。

#### 2、 与抽象工厂模式对比

抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品：具有不同分类维度的产品组合，采用抽象工厂模式则是不需要关心构建过程，只关心什么产品由什么工厂生产即可。

建造者模式则是要求按照指定的蓝图建造产品，它的主要目的是通过组装零配件而产生一个新产品。

如果将抽象工厂模式看成汽车配件生产工厂，生产一个产品族的产品，那么建造者模式就是一个汽车组装工厂，通过对部件的组装可以返回一辆完整的汽车。

#### 3、使用场景：

1) 某个对象有复杂的内部结构，通常包含多个成员属性，而且属性是可选的。

2) 相同的方法，不同的执行顺序，产生不同的对象或不同的运行结果。

3) 当创建一个对象需要很多步骤时，适合使用建造者模式。

#### 4、优缺点

**优点：**

- 建造者模式的封装性很好。使用建造者模式可以有效的封装变化，在使用建造者模式的场景中，一般产品类和建造者类是比较稳定的，因此，将主要的业务逻辑封装在指挥者类中对整体而言可以取得比较好的稳定性。
- 在建造者模式中，客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解耦，使得相同的创建过程可以创建不同的产品对象。
- 可以更加精细地控制产品的创建过程 。将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。
- 建造者模式很容易进行扩展。如果有新的需求，通过实现一个新的建造者类就可以完成，基本上不用修改之前已经测试通过的代码，因此也就不会对原有功能引入风险。符合开闭原则。

**缺点：**

造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
