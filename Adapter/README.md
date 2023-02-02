## 适配器模式（Adapter）

适配器模式

### 一、说明

适配器模式是一种对象结构型模式。将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。

适配器模式有分三类：

- 类适配器模式（class adapter pattern）

  类适配器模式在编译时实现target（目标）接口。

  这种适配器模式使用了多个实现了接口或已经存在的接口的多态。

  比较典型的就是：target接口被创建为一个纯粹的接口，如Java不支持多继承的语言。

- 对象适配器模式（object adapter pattern）

  对象适配器模式在运行时实现target（目标）接口。

  在这种适配器模式中，适配器包装了一个类实例。

  在这种情况下，适配器调用包装对象实例的方法。

- 缺省适配器模式（default adapter pattern），也叫默认适配器模式、接口适配器模式

  适用于一个接口不想使用所有的方法的情况。

  当不需要全部实现接口提供的方法时，可以设计一个适配器抽象类实现接口，并为接口中的每个方法提供默认方法（空方法），抽象类的子类就可以有选择的覆盖父类的某些方法实现需求。

  在java8后，接口中可以有default方法，就不需要这种缺省适配器模式了。接口中方法都设置为default，实现为空就可以了

### 二、角色

- 目标接口（Target）角色：

  客户所期待的接口。目标可以是具体的或抽象的类，也可以是接口。

- 需要适配的类（Adaptee）：

  需要适配的类或适配者类。

- 适配器（Adapter）：

  通过包装一个需要适配的对象，把原接口转换成目标接口。

### 三、代码说明

#### 3.1、类适配器

**1、UML**

![image-20230202143554242](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202143554242.png)

**2、核心代码**

```java
/**
 * 目标类，被适配的类
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:35
 */
public class Adaptee {

    public void request() {
        System.out.println("do request....");
    }
}

/**
 * response接口，目标接口
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:38
 */
public interface Target {

    void response();
}

/**
 * 类适配器
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:49
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void response() {
        super.request();
    }
}

/**
 * Response实现类
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:39
 */
public class TargetImpl implements Target {

    @Override
    public void response() {
        System.out.println("do response....");
    }
}

/**
 * 使用
 * 适配器继承Adaptee类同时实现Target接口，这种方式无法对Adaptee的子类进行适配
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:42
 */
public class Client {
    private static void todo(Target target) {
        target.response();
    }

    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        todo(classAdapter);
    }
}

// =============================================================================
Connected to the target VM, address: '127.0.0.1:63465', transport: 'socket'
do request....
Disconnected from the target VM, address: '127.0.0.1:63465', transport: 'socket'
```

#### 3.2、接口适配器

接口适配器是一个特殊的使用方式，主要是简化开发，只需要实现需要的方法即可

**1、UML**

![image-20230202144001736](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202144001736.png)

**2、核心代码**

```java
/**
 * @author : cui_feng
 * @since : 2023-01-09 14:23
 */
public interface Target {
    void methodOne();
    void methodTwo();
    void methodThree();
    void methodFour();
}

/**
 * 接口适配器
 * 实现Target接口中的所有方法
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:29
 */
public class InterfaceAdapter implements Target{
    @Override
    public void methodOne() {
    }

    @Override
    public void methodTwo() {
    }

    @Override
    public void methodThree() {
    }

    @Override
    public void methodFour() {
    }
}

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:27
 */
public class Client {

    // 只需要方法三
    private static void todoThree(Target target) {
        target.methodThree();
    }

    // 只需要方法二
    private static void todoTwo(Target target) {
        target.methodTwo();
    }

    public static void main(String[] args) {

        // 使用传统方式
        todoThree(new Target() {
            @Override
            public void methodOne() {
            }
            @Override
            public void methodTwo() {
            }
            @Override
            public void methodThree() {
                System.out.println("do methodThree....");
            }

            @Override
            public void methodFour() {
            }
        });

        todoTwo(new Target() {
            @Override
            public void methodOne() {
            }
            @Override
            public void methodTwo() {
                System.out.println("do methodTwo....");
            }
            @Override
            public void methodThree() {
            }
            @Override
            public void methodFour() {
            }
        });

        System.out.println("=============================================");

        // 使用接口适配器
        todoThree(new InterfaceAdapter() {
            @Override
            public void methodThree() {
                System.out.println("do methodThree....");
            }
        });

        todoTwo(new InterfaceAdapter(){
            @Override
            public void methodTwo() {
                System.out.println("do methodTwo....");
            }
        });
    }
}
```

#### 3.3、对象适配器

适配器中持有Adaptee对象并实现Target接口，优先推荐这种方式

**1、UML**

![image-20230202144500802](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202144500802.png)

**2、核心代码**

```java
/**
 * 目标类
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:35
 */
public class Adaptee {
    public void request() {
        System.out.println("do request....");
    }
}

/**
 * response接口
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:38
 */
public interface Target {
    void response();
}

/**
 * 对象适配器
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:40
 */
public class ObjectAdapter implements Target {
    // 组合的方式，持有一个Adaptee对象，通过调用Adaptee的方法实现适配
    @Getter
    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void response() {
        adaptee.request();
    }
}

/**
 * Response实现类
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:39
 */
public class TargetImpl implements Target {
    @Override
    public void response() {
        System.out.println("do response....");
    }
}

/**
 * 使用
 * 适配器中持有Adaptee对象并实现Target接口，优先推荐这种方式
 *
 * @author : cui_feng
 * @since : 2023-01-09 13:42
 */
public class Client {
    private static void todo(Target target) {
        target.response();
    }

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        ObjectAdapter objectAdapter = new ObjectAdapter(adaptee);
        todo(objectAdapter);
    }
}
```

### 四、总结

三种适配器模式，本质上是现有的不兼容的接口转换为需要的接口。

类适配器模式，以继承现有类的方式转换。

对象适配器模式，以聚合对象实例的方式转换。

接口适配器模式，以实现接口的方式转换。

**适配器模式是在现有的类和系统都不易修改的情况下使用，在系统设计之初慎用适配器模式。**

使用场景：

1) 系统需要使用现有的类，而此类的接口不符合系统的需要
2) 想要建立可以重复使用的类，与一些彼此之间没有太大关联的、包括未来可能使用的类一起工作，这些类不一定有一致的接口。 
3) 通过接口转换，将一个类插入另一个类系中。