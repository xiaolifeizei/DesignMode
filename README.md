# 设计模式 Design Pattern

设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。

设计模式分为三种类型，共23种：

- **创建型模式**：[单例模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Singleton)、[抽象工厂模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/AbstractFactory)、[建造者模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Builder)、[工厂模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Factory)、[原型模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Prototype)。
- **结构型模式**：[适配器模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Adapter)、[桥接模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Bridge)、[装饰模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Wrapper)、[组合模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Composite)、[外观模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Facade)、[享元模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Flyweight)、[代理模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Proxy)。
- **行为型模式**：[模版方法模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/TemplateMethod)、[命令模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Command)、[迭代器模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Iterator)、[观察者模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Observer)、[中介者模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Mediator)、[备忘录模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Memento)、[解释器模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Interpreter)、[状态模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/State)、[策略模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Strategy)、[责任链模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/ChainOfResponsibility)、[访问者模式](https://github.com/xiaolifeizei/DesignPattern/tree/master/Visitor)。



## 一、相似设计模式的区别

### 1.1、代理、桥接、装饰器、适配器 

代理、桥接、装饰器、适配器，这 4 种模式是比较常用的结构型设计模式。它们的代码结构非常相似。笼统来说，它们都可以称为 Wrapper 模式，也就是通过 Wrapper 类二次封装原始类。

- 代理模式： 代理模式在不改变原始类接口的条件下，为原始类定义一个代理类，主要目的是控制访问，而非加强功能，这是它跟装饰器模式最大的不同。

- 桥接模式： 桥接模式的目的是将接口部分和实现部分分离，从而让它们可以较为容易、也相对独立地加以改变。

- 装饰器模式： 装饰者模式在不改变原始类接口的情况下，对原始类功能进行增强，并且支持多个装饰器的嵌套使用。

- 适配器模式： 适配器模式是一种事后的补救策略。适配器提供跟原始类不同的接口，而代理模式、装饰器模式提供的都是跟原始类相同的接口。

## 二、设计模式中各类间的关系

![img](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/v2-819e2d622af2c366a43a19895a6ba922_720w.webp)

