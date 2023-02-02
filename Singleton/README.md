## 单例模式（Singleton）

单例模式

### 一、说明

单例模式是一种常见的设计模式。只能有一个实例，且该类需要自行创建这个实例，并对其他的类提供调用这一实例的方法。

单例模式分：

- 懒汉式单例

  用到的时候才去检查有没有实例，如果有则直接返回，没有则新建。

- 饿汉式单例

  在初始化的时候就要创建好，不管你有没有用到

### 二、角色

无

### 三、代码说明

#### 3.1、饿汉式

```java
/**
 * 饿汉式
 *
 * @author : cui_feng
 * @since : 2023-01-05 11:51
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
```

#### 3.2、懒汉式

```java
/**
 * 懒汉式
 *
 * @author : cui_feng
 * @since : 2023-01-05 11:43
 */
@Data
public class Singleton {

    // volatile 禁止重排
    private volatile static Singleton singleton = null;

    /**
     * 私有化构造方法
     */
    private Singleton() {

    }

    //静态工厂方法
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                // DCL 双重检查锁
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
```

#### 3.3、静态内部类方式

```java
/**
 * 静态内部类
 * 多线程安全：是
 * 懒加载：是
 *
 * @author : cui_feng
 * @since : 2023-01-05 11:56
 */
public class Singleton {

    /**
     * 私有化构造方法
     */
    private Singleton() {

    }

    private static final class SingletonHolder {
        static final Singleton singleton = new Singleton();
    }

    //静态工厂方法
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }
}

```

### 四、总结

饿汉模式天生线程安全，在类加载的同时已经创建好一个静态对象，调用时反应速度快，但是由于对象是提前创建的，所以会占据一定的内存，是以空间换时间的策略。

懒汉模式起到了懒加载的效果，但是如果在多线程下使用需要使用锁来保证其线程的安全性，对象返回效率比较低，属于以时间换空间的策略。
