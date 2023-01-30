## 原型模式（Prototype）

原型模式

### 一、说明

原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象。

这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用。

### 二、角色

- 原型（Prototype）角色

  声明一个具体原型对象必须实现的克隆自己的接口方法，如：clone()

- 具体原型（Concrete Prototype）角色

  实现原型角色的克隆方法，它是可被复制的对象。

- 访问（Client）角色

  调用具体原型角色中的克隆方法来复制新的对象。

### 三、总结

原型模式分为浅拷贝和深拷贝两种类型

- 浅拷贝： 

  对于基本数据类型，会直接复制值给拷贝对象；对于引用数据类型，只拷贝对象地址，指向原来对象的地址。

  Java中的Object类中提供了clone()方法来实现浅拷贝

- 深拷贝： 

  无论基本类型还是引用类型，全部拷贝为一个新的对象，属性中引用的其他对象也会被拷贝，不指向原有对象的地址。

  有两种方法：

  1. 需在重写clone方法时对引用进行单独的处理

     ```java
     public class SubjectDeepClone implements Cloneable{
     
         private SubjectDeepClone partOne;
     
     	@Override
         protected SubjectDeepClone clone() {
             try {
                 // 先克隆自己
                 SubjectDeepClone subjectDeepClone = (SubjectDeepClone) super.clone();
                 // 单独处理引用类型实现深拷贝
                 if (partOne != null) {
                     partOne = (SubjectDeepClone) partOne.clone();
                 }
                 return subjectDeepClone;
             } catch (CloneNotSupportedException e) {
                 e.printStackTrace();
             }
     
             return null;
         }
     }
     ```

  2. 使用序列化机制

     ```java
     public class SubjectSerializableDeepClone implements Serializable {
     
         private SubjectSerializableDeepClone partOne;
     
         public SubjectSerializableDeepClone(SubjectSerializableDeepClone partOne) {
             this.partOne = partOne;
         }
     
         public SubjectSerializableDeepClone clone() {
             try {
                 // 将对象写出到流
                 ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos);
                 oos.writeObject(this);
     
                 ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis);
                 return (SubjectSerializableDeepClone) ois.readObject();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return null;
         }
     }
     ```

使用场景：

1. 对象的创建非常复杂，可以使用原型模式快捷的创建对象。
2. 性能和安全要求比较高。
