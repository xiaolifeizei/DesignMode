## 桥接模式（Bridge）

桥接模式

### 一、说明

桥接模式是结构型模式。可以让一个类在两个独立的维度变化，这两个维度都可以进行扩展。

- 设计意图：将抽象部分与实现部分分离，使它们都可以独立的变化
- 模式本质：将继承改为组合的方式来解决一个类在两个维度上的变化问题

### 二、角色

- 抽象化（Abstraction）角色：

  定义抽象类，并包含一个对实现化对象的引用。提供高层控制逻辑， 依赖于完成底层实际工作的实现对象。

- 扩展抽象化（Refined Abstraction）角色：

  抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。

- 实现化接口（Implementor）角色：

  定义实现化角色的接口，供扩展抽象化角色调用

- 具体实现类（Concrete Implementor）角色：

  给出实现化角色接口的具体实现

### 三、代码说明

#### 3.1、UML

![image-20230202145847019](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202145847019.png)

#### 3.2、核心代码

```java
/**
 * 接口
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:56
 */
public interface Implementor {
    void request();
    void response();
}

/**
 * 抽象类（桥接类）
 * 维护了 implementor，二者是聚合关系
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:55
 */
public abstract class Abstraction {
    private final Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    protected void request() {
        implementor.request();
    }
    protected void response() {
        implementor.response();
    }
    public void show() {
        System.out.println("do show....");
    }
}

/**
 * 接口实现类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:58
 */
public class ConcreteImplementorFirst implements Implementor {
    @Override
    public void request() {
        System.out.println("the first request....");
    }
    @Override
    public void response() {
        System.out.println("the first response....");
    }
}

/**
 * 接口实现类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:58
 */
public class ConcreteImplementorSecond implements Implementor {
    @Override
    public void request() {
        System.out.println("the second request....");
    }
    @Override
    public void response() {
        System.out.println("the second response....");
    }
}

/**
 * 抽象类子类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:57
 */
public class RefindedAbstractionOne extends Abstraction {
    public RefindedAbstractionOne(Implementor implementor) {
        super(implementor);
    }
    @Override
    protected void request() {
        System.out.println("the one request....");
        super.request();
    }
    @Override
    protected void response() {
        System.out.println("the one response....");
        super.response();
    }
}

/**
 * 抽象类子类
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:57
 */
public class RefindedAbstractionTwo extends Abstraction {
    public RefindedAbstractionTwo(Implementor implementor) {
        super(implementor);
    }
    @Override
    protected void request() {
        System.out.println("the two request....");
        super.request();
    }
    @Override
    protected void response() {
        System.out.println("the two response....");
        super.response();
    }
}

/**
 * 使用
 * 把抽象（Abstraction）与行为实现（Implementation）分离开来，
 * 从而可以保持各部分的独立性以及他们的功能扩展，通过桥接模式可以使
 * 两种类型相互排列组合，极大的提供了系统的灵活性
 *
 * @author : cui_feng
 * @since : 2023-01-09 14:55
 */
public class Client {

    public static void main(String[] args) {
        Abstraction oneFist = new RefindedAbstractionOne(new ConcreteImplementorFirst());
        Abstraction oneSecond = new RefindedAbstractionOne(new ConcreteImplementorSecond());
        Abstraction twoFirst = new RefindedAbstractionTwo(new ConcreteImplementorFirst());
        Abstraction twoSecond = new RefindedAbstractionTwo(new ConcreteImplementorSecond());

        oneFist.request();
        oneFist.response();
        oneFist.show();

        System.out.println("=============================================");

        oneSecond.request();
        oneSecond.response();
        oneSecond.show();

        System.out.println("=============================================");

        twoFirst.request();
        twoFirst.response();
        twoFirst.show();

        System.out.println("=============================================");

        twoSecond.request();
        twoSecond.response();
        twoSecond.show();
    }
}

// ===============================================================================
Connected to the target VM, address: '127.0.0.1:60243', transport: 'socket'
the one request....
the first request....
the one response....
the first response....
do show....
=============================================
the one request....
the second request....
the one response....
the second response....
do show....
=============================================
the two request....
the first request....
the two response....
the first response....
do show....
=============================================
the two request....
the second request....
the two response....
the second response....
do show....
Disconnected from the target VM, address: '127.0.0.1:60243', transport: 'socket'
```

### 四、总结

桥接模式通过的将继承改为组合的方式来解决一个类在两个维度上的变化问题（适配器模式只在一个维度实现继承），所以不会因为多维度、多层次继承导致系统类的个数急剧增加，这就让构件的抽象化角色和具体化角色之间增加了更多的灵活性。

使用场景：

1) 如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系。 
2) 对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。 
3) 一个类存在两个独立变化的维度，且这两个维度都需要进行扩展

**注意事项：**对于两个独立变化的维度，使用桥接模式再适合不过了。

如何使用：

1) 明确类中独立的维度。独立的概念可能是：抽象/平台，域/基础设施，前端/后端或接口/实现。
   了解客户端的业务需求，并在抽象基类中定义它们。
2) 确定在所有平台上都可执行的业务。并在通用实现接口中声明抽象部分所需的业务。
   为你域内的所有平台创建实现类，但需确保它们遵循实现部分的接口。
3) 在抽象类中添加指向实现类型的引用成员变量。抽象部分会将大部分工作委派给该成员变量所指向的实现对象。
4) 如果你的高层逻辑有多个变体，则可通过扩展抽象基类为个变体创建一个精确抽象。
5) 客户端代码必须将实现对象传递给抽象部分的构造函数才能使其能够相互关联。此后，客户端只需与抽象对象进行交互，无需和实现对象打交道。