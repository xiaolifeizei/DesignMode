## 访问者模式（Visitor）

访问者模式（号称是最复杂的设计模式）

### 一、说明

访问者模式是对象行为型设计模式。将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。系统中有一些固定结构的对象（元素），在对象内部提供一个accept()方法接受访问者对象的访问，不同的访问者对同一元素的访问内容不同，所以相同的元素可以产生不同的访问结果。

- 设计意图：将数据操作与数据结构分离

- 设计目的：封装一些施加于某种数据结构元素之上的操作，当操作需要修改时，数据结构保持不变

举个例子：

您（Concrete Visitor）去朋友家做客，朋友（Concrete Element）接受了（accept）您的访问，您通过朋友的描述（visit），然后对朋友的描述做出一个判断，这就是访问者模式。

### 二、角色

- 抽象元素（Element）角色：

  定义一个接受访问的方法（如：accept），参数为访问者（Visitor）对象。

- 具体元素（Concrete Element）角色：

  提供接受访问者访问的具体实现，调用访问者的visit()，并定义额外的数据操作方法。

- 抽象访问者（Visitor）角色：

  声明一个或者多个方法操作，形成所有的具体访问者角色必须实现的接口。

  这个角色主要是定义对具体元素的访问方法visit()，理论上来说方法数等于元素（固定类型的对象，也就是被访问者）个数。

- 具体访问者（Concrete Visitor）角色：

  实现对具体元素的访问visit方法，参数就是具体元素。

- 结构对象（Object Structure）角色：

  提供一个方法来访问所有的元素，可以提供一个高层接口允许访问者访问它的元素；如有需要，可以设计成一个复合对象或者一个聚集（如一个列表或无序集合）。

### 三、总结

能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能，并通过访问者来定义整个对象结构通用的功能，从而提高复用程度，还可以使用访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，这样每一个访问者的功能都比较单一。

不适用于对象结构中的类经常变化的情况，因为对象结构发生了改变，访问者的接口和访问者的实现都要发生相应的改变，代价太高，而且通常需要对象结构开放内部数据给访问者和Object Structure，破坏了对象的封装性。



使用场景：

1) 类中包含各种类型的元素，类结构比较稳定，元素类型不会经常变动，但是频繁需要给这些元素添加新的操作
2) 需要对一个对象结构中的对象进行很多不同的且不相关的操作，而且需要避免让这些操作"污染"这些对象的类（分离出操作）
3) 访问者模式可以对功能进行统一，可以做报表、UI、拦截器与过滤器。

4) JDK的NIO中的 FileVisitor接口采用的就是访问者模式。

### 四、扩展

1. 分派：

   根据对象的类型而对方法进行的选择，就是分派（Dispatch），分派又分为两种，静态分派和动态分派

   - 静态分派（Static Dispatch）:

     发生在编译时期，分派根据静态类型信息发生。方法重载就是静态分派。

     ```java
     public class Animal {
     }
     public class Dog extends Animal {
     }
     public class Cat extends Animal {
     }
     public class Execute {
         public void execute(Animal a) {
             System.out.println("Animal");
         }
         public void execute(Dog d) {
             System.out.println("dog");
         }
         public void execute(Cat c) {
             System.out.println("cat");
         }
     }
     public class Client {
         public static void main(String[] args) {
             Animal a = new Animal();
             Animal a1 = new Dog();
             Animal a2 = new Cat();
             Execute exe = new Execute();
             exe.execute(a);
             exe.execute(a1);
             exe.execute(a2);
         }
     }
     ```

     上面的程序执行结果为：

     ```java
     Animal
     Animal
     Animal    
     ```

     不管在运行的时候传入的实际类型是什么，它永远都只会执行 execute(Animal a)这个方法，即 : 重载是静态绑定，**重载方法的分派是根据静态类型进行的，这个分派过程在编译时期就完成了。**

   - 动态分派（Dynamic Dispatch）：

     发生在运行时期，动态分派动态地置换掉某个方法，Java通过方法的重写支持动态分派（多态）。

     ```java
     public class Animal {
         public void execute() {
             System.out.println("Animal");
         }
     }
     public class Dog extends Animal {
         @Override
         public void execute() {
             System.out.println("dog");
         }
     }
     public class Cat extends Animal {
         @Override
         public void execute() {
             System.out.println("cat");
         }
     }
     public class Client {
         public static void main(String[] args) {
             Animal a = new Dog();
             a.execute();
             Animal a1 = new Cat();
             a1.execute();
         }
     }
     ```

     运行结果如下：

     ```java
     dog
     cat    
     ```

     Java编译器在编译时期并不总是知道哪些代码会被执行，因为编译器仅仅知道对象的静态类型，而不知道对象的真实类型；而方法的调用则是根据对象的真实类型，而不是静态类型。

2. 人为实现动态绑定

   如果希望使用重载的时候，程序能够根据传入参数的实际类型动态地调用相应的方法，也就是说，我们希望Java的重载是动态的，而不是静态的。但是由于Java的重载不是动态绑定，只能通过程序来人为判断，我们一般会使用instanceof操作符来进行类型的判断

   ``` java
   public class Animal {
   }
   public class Dog extends Animal {
   }
   public class Cat extends Animal {
   }
   public class Execute {
       public void execute(Animal a) {
           if (a instanceof Dog) {
               System.out.println("dog");
           } else if (a instanceof Cat) {
               System.out.println("cat");
           } else {
               System.out.println("Animal");
           }  
       }
       public void execute(Dog d) {
           System.out.println("dog");
       }
       public void execute(Cat c) {
           System.out.println("cat");
       }
   }
   public class Client {
       public static void main(String[] args) {
           Animal a = new Animal();
           Animal a1 = new Dog();
           Animal a2 = new Cat();
           Execute exe = new Execute();
           exe.execute(a);
           exe.execute(a1);
           exe.execute(a2);
       }
   }
   ```

   运行结果：

   ```java
   Animal
   dog
   cat    
   ```

   这种方式是伪动态的，仍然需要通过程序来判断类型。假如有很多个子类的话，还是这样来实现显然是不合适的，必须通过其他方式实现，我们可以使用双分派方式来实现动态绑定

3. 双分派

   所谓双分派技术就是在选择一个方法的时候，不仅仅要根据消息接收者（receiver）的运行时区别，还要根据参数的运行时区别。

   ```java
   public class Animal {
       public void accept(Execute exe) {
           exe.execute(this);
       }
   }
   public class Dog extends Animal {
       public void accept(Execute exe) {
           exe.execute(this);
       }
   }
   public class Cat extends Animal {
       public void accept(Execute exe) {
           exe.execute(this);
       }
   }
   public class Execute {
       public void execute(Animal a) {
           System.out.println("animal");
       }
       public void execute(Dog d) {
           System.out.println("dog");
       }
       public void execute(Cat c) {
           System.out.println("cat");
       }
   }
   public class Client {
       public static void main(String[] args) {
           Animal a = new Animal();
           Animal d = new Dog();
           Animal c = new Cat();
           Execute exe = new Execute();
           a.accept(exe);
           d.accept(exe);
           c.accept(exe);
       }
   }
   ```

   运行结果如下：

   ```java
   animal
   dog
   cat   
   ```

   客户端**将Execute对象做为参数传递给Animal类型的变量的accept方法，这里完成第一次分派**，因为是方法重写，所以是动态分派，也就是子类去执行accept()方法；子类执行accept方法时反向调用Execute的象并**将自己（this）作为参数传递给Execute对象的execute方法，这里完成了第二次分派**。Execute类中有多个重载的方法，**而传递的是this**，就是具体的实际类型（子类）的对象，所以也是动态分派。

   **双分派是实现动态绑定的本质。客户端调用方法（accept）时由于Java的多态，实际是由子类来执行，执行时子类再调用重载方法（execute）时传的是自己（this），也就是子类的类型，所以重载就是（看起来）动态的了。**
