## 中介者模式（Mediator）

中介者模式又称为调停者模式

### 一、说明

中介者模式是一种对象行为型模式，用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。通过引入中介者对象，可以将系统的网状结构变成以中介者为中心的星形结构 ，任何一个类的变动，只会影响类本身，以及中介者，这样就减小了系统的耦合。简单说就是引入一个“中介”，用于协调各个对象的关系，各个对象之间不用那么直白的直接调，对象只需要调用中介的方法，中介内部进行逻辑判断，由中介去调用各个对象的方法。

如果在一个系统中对象之间存在多对多的关系，可以将对象之间的一些交互行为的细节从各个对象中分离出来，并集中封装在一个中介者对象中，并由该中介者进行统一协调，这样对象之间多对多的复杂关系就转化为相对简单的一对多关系。通过引入中介者来简化对象之间的复杂交互，中介者模式是“迪米特法则”的一个典型应用。

中介者模式的核心在于中介者类的引入，中介者类承担了两方面的职责： 

1) 中转作用（结构性）：通过中介者提供的中转作用，各个同事对象就不再需要显式引用其他同事，当需要和其他同事进行通信时，可通过中介者来实现间接调用。该中转作用属于中介者在结构上的支持。
2) 协调作用（行为性）：中介者可以更进一步的对同事之间的关系进行封装，同事可以一致的和中介者进行交互，而不需要指明中介者需要具体怎么做，中介者根据封装在自身内部的协调逻辑，对同事的请求进行进一步处理，将同事成员之间的关系行为进行分离和封装。该协调作用属于中介者在行为上的支持。



![在这里插入图片描述](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/f26ce128d67c4dd1a28535d15c16e019.png)



### 二、角色

- 抽象中介者（Mediator）角色：

  中介者的接口，定义了同事对象到中介者对象之间的接口，该接口用于与各同事对象之间的通信

- 具体中介者（Concrete Mediator）角色： 

  实现抽象中介者的方法，是抽象中介者的子类 。需要知道所有的具体同事类，同时需要从具体的同事类那里接收信息，并且向其他具体的同事类发送信息。并协调各个同事角色之间的交互关系， 持有、维护各个同事对象的引用，通过协调各个同事对象来实现协作

- 抽象同事类（Colleague）角色：

  定义各个同事类中的公有的方法，并声明了一些抽象方法来供子类实现，同时持有一个抽象中介者的引用，子类通过中介者的引用来间接完成与其他同事类的通信

- 具体同事类（Concrete Colleague）角色： 

  抽象同事类的子类，每一个同事对象在需要和其他同事对象通信时，先与中介者通信，通过中介者来间接完成与其他同事类的通信；在具体同事类中实现了在抽象同事类中声明的抽象方法，所以每个具体同事类都只需要知道自己的行为即可。

UML如下

![img](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/20181105013219337.jpg)

### 三、代码说明

#### 3.1、第一个示例

**1、UML**

![image-20230202092332229](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202092332229.png)

**2、核心代码**

```java
/**
 * 抽象同事类
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:36
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void contact(String msg);

    public void show(String msg) {
        System.out.println(this.getClass().getSimpleName() + " copy:" + msg);
    }
}


/**
 * 抽象中介者
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:34
 */
public interface Mediator {
    void contact(String msg, Colleague colleague);
}

/**
 * 具体中介者
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:40
 */
@Data
public class ConcreteMediator implements Mediator{

    private Colleague colleagueOne;

    private Colleague colleagueTwo;

    @Override
    public void contact(String msg, Colleague colleague) {
        if (colleague instanceof ConcreteColleagueOne) {
            colleagueTwo.show(msg);
        } else {
            colleagueOne.show(msg);
        }
    }
}

/**
 * 具体同事类
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:38
 */
public class ConcreteColleagueOne extends Colleague{

    public ConcreteColleagueOne(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void contact(String msg) {
        mediator.contact(msg, this);
    }
}

/**
 * 具体同事类
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:38
 */
public class ConcreteColleagueTwo extends Colleague{

    public ConcreteColleagueTwo(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void contact(String msg) {
        mediator.contact(msg, this);
    }
}

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-13 10:44
 */
public class Client {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague one = new ConcreteColleagueOne(mediator);
        Colleague two = new ConcreteColleagueTwo(mediator);

        mediator.setColleagueOne(one);
        mediator.setColleagueTwo(two);

        one.contact("is any body here?");
        two.contact("I'm here!");
    }
}

// ============================================================================================

Connected to the target VM, address: '127.0.0.1:49917', transport: 'socket'
ConcreteColleagueTwo copy:is any body here?
ConcreteColleagueOne copy:I'm here!
Disconnected from the target VM, address: '127.0.0.1:49917', transport: 'socket'

Process finished with exit code 0
```

#### 3.2、第二个示例

**1、UML**

![image-20230202092839623](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230202092839623.png)

**2、核心代码**

```java
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.attach(this);
    }

    /**
     * 数据更改方法
     */
    public abstract void changed();
}

public abstract class Mediator {

    @Getter
    protected final List<Colleague> colleagues = new ArrayList<>();

    public void attach(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            this.colleagues.add(colleague);
        }
    }

    public abstract void operation(Colleague colleague);

    public void close() {
        System.out.println("-------------------------------------");
        colleagues.forEach(item -> {
            if (item instanceof ConcreteColleagueOne) {
                ((ConcreteColleagueOne) item).flash();
            } else {
                ((ConcreteColleagueTwo) item).finish();
            }
        });
    }
}

public class ConcreteMediator extends Mediator{

    @Override
    public void operation(Colleague colleague) {
        if (colleague instanceof ConcreteColleagueOne) {
            colleagues.stream()
                    .filter(item -> item instanceof ConcreteColleagueTwo)
                    .collect(Collectors.toList())
                    .forEach(item -> ((ConcreteColleagueTwo) item).finish());
        } else {
            colleagues.stream()
                    .filter(item -> item instanceof ConcreteColleagueOne)
                    .collect(Collectors.toList())
                    .forEach(item -> ((ConcreteColleagueOne) item).flash());
        }
    }
}

public class ConcreteColleagueOne extends Colleague{

    public ConcreteColleagueOne(Mediator mediator) {
        super(mediator);
    }

    public void flash() {
        System.out.println("ConcreteColleagueOne flash....");
    }

    @Override
    public void changed() {
        System.out.println("ConcreteColleagueOne changed....");
        mediator.operation(this);
    }
}

public class ConcreteColleagueTwo extends Colleague{

    public ConcreteColleagueTwo(Mediator mediator) {
        super(mediator);
    }


    public void finish() {
        System.out.println("ConcreteColleagueTwo finish....");
    }

    @Override
    public void changed() {
        System.out.println("ConcreteColleagueTwo changed....");
        mediator.operation(this);
    }
}

public class Client {

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();
        Colleague one = new ConcreteColleagueOne(mediator);
        Colleague two = new ConcreteColleagueTwo(mediator);

        mediator.attach(new ConcreteColleagueTwo(mediator));

        one.changed();
        two.changed();

        mediator.close();
    }
}

// ==============================================================================
Connected to the target VM, address: '127.0.0.1:49690', transport: 'socket'
ConcreteColleagueOne changed....
ConcreteColleagueTwo finish....
ConcreteColleagueTwo finish....
ConcreteColleagueTwo changed....
ConcreteColleagueOne flash....
-------------------------------------
ConcreteColleagueOne flash....
ConcreteColleagueTwo finish....
ConcreteColleagueTwo finish....
Disconnected from the target VM, address: '127.0.0.1:49690', transport: 'socket'

Process finished with exit code 0

```



### 四、总结

中介者模式通过把多个同事对象之间的交互封装到中介者对象里面，从而使得同事对象之间**`松散耦合`**，基本上可以做到互补依赖。这样一来，同事对象就可以独立地变化和复用，而不再像以前那样“牵一处而动全身”了。多个同事对象的交互，被封装在中介者对象里面**`集中控制交互`**，使得这些交互行为发生变化的时候，只需要修改中介者对象就可以了，当然如果是已经做好的系统，那么就扩展中介者对象，而各个同事类不需要做修改。

在中介者模式的实际使用过程中，如果需要引入新的具体同事类，只需要继承抽象同事类并实现其中的方法即可，由于具体同事类之间并无直接的引用关系，因此原有所有同事类无须进行任何修改，它们与新增同事对象之间的交互可以通过修改或者增加具体中介者类来实现；如果需要在原有系统中增加新的具体中介者类，只需要继承抽象中介者类（或已有的具体中介者类）并覆盖其中定义的方法即可，在新的具体中介者中可以通过不同的方式来处理对象之间的交互，也可以增加对新增同事的引用和调用。在客户端中只需要修改少许代码（如果引入配置文件的话有时可以不修改任何代码）就可以实现中介者的更换。

- 中介者模式适用情况包括：系统中对象之间存在复杂的引用关系，产生的相互依赖关系结构混乱且难以理解；一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象；想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。
- 中介者模式与代理模式相比，中介模式更加关注于多个模块通信的解耦，代理模式更加关注于权限和封装。

使用场景：

1) 存在于多对多通讯的场景
2) 系统中对象之间存在复杂的引用关系，产生的相互依赖关系结构混乱且难以理解
3) 一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象
3) 想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类，如果需要改变行为则可以增加新的具体中介者类。

