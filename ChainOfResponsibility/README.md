## 责任链模式（Chain Of Responsibility）

责任链模式

### 一、说明

责任链模式（Chain Of Responsibility）是一种行为设计模式， 允许你将请求沿着处理者链进行发送。收到请求后， 每个处理者均可对请求进行处理， 或将其传递给链上的下个处理者，其实就是一个链表。可以动态地修改责任链，同时也使得每个责任链上的对象可以专注于自己的问题，这样思路清晰，便于扩展。

责任链模式的特点：

- 链上的每个对象都有机会处理请求
- 链上的每个对象都持有下一个要处理对象的引用
- 链上的某个对象无法处理当前请求，那么它会把相同的请求传给下一个对象

![img](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/801753-20190414171911634-504849462.png)

### 二、角色

- **抽象处理者（Handler）角色：**

  定义一个处理请求的接口，包含抽象处理方法和一个后继连接。

- **具体处理者（Concrete Handler）角色：**

  实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。

- **客户类（Client）角色：**

  创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。

UML如下：

![在这里插入图片描述](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/0547e86c0ebc4cea9fe0c090f9ff7b7b.png)

### 三、代码说明

#### 3.1、第一个示例

**1、UML**

![image-20230206103539912](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230206103539912.png)

**2、核心代码**

```java
/**
 * 抽象处理者
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:27
 */
public abstract class AbstractHandler {

    /**
     * 下一关用当前抽象类来接收
     */
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract int handler();
}

/**
 * 具体处理者1
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:28
 */
public class ConcreteHandlerOne extends AbstractHandler{

    private int play(){
        return 80;
    }

    @Override
    public int handler() {
        System.out.println("第一关-->FirstPassHandler");
        int score = play();
        if(score >= 80){
            //分数>=80 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}

/**
 * 具体处理者2
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:28
 */
public class ConcreteHandlerTwo extends AbstractHandler{

    private int play(){
        return 90;
    }

    public int handler(){
        System.out.println("第二关-->SecondPassHandler");

        int score = play();
        if(score >= 90){
            //分数>=90 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }

        return score;
    }
}

/**
 * 具体处理者3
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:28
 */
public class ConcreteHandlerThree extends AbstractHandler{

    private int play(){
        return 95;
    }

    public int handler(){
        System.out.println("第三关-->ThirdPassHandler");
        int score = play();
        if(score >= 95){
            //分数>=95 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}

/**
 * 使用
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:31
 */
public class Client {

    public static void main(String[] args) {
        ConcreteHandlerOne concreteHandlerOne = new ConcreteHandlerOne();//第一关
        ConcreteHandlerTwo concreteHandlerTwo = new ConcreteHandlerTwo();//第二关
        ConcreteHandlerThree concreteHandlerThree = new ConcreteHandlerThree();//第三关

        // 和上面没有更改的客户端代码相比，只有这里的set方法发生变化，其他都是一样的
        concreteHandlerOne.setNext(concreteHandlerTwo);//第一关的下一关是第二关
        concreteHandlerTwo.setNext(concreteHandlerThree);//第二关的下一关是第三关

        //说明：因为第三关是最后一关，因此没有下一关

        //从第一个关卡开始
        concreteHandlerOne.handler();
    }
}
```

#### 3.2、第二个示例

这个示例通过枚举来维护处理器的关系，通过反射来获取具体的处理器对象。

定义了一组拦截器，用来拦截请求，实现不同的功能，先走API接口限流处理器，再走黑名单处理器，最后是Session处理器。

**1、UML**

![image-20230206103933932](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230206103933932.png)

**2、核心代码**

```java
public abstract class GatewayHandler {
    @Setter
    protected GatewayHandler next;
    public abstract void service();
}

public class ApiLimitGatewayHandler extends GatewayHandler{
    @Override
    public void service() {
        System.out.println("进入ApiLimitGatewayHandler拦截器。。。。");
        if (next!=null) {
            next.service();
        }
    }
}

public class BlacklistGatewayHandler extends GatewayHandler{
    @Override
    public void service() {
        System.out.println("进入BlacklistGatewayHandler拦截器。。。。");
        if (next!=null) {
            next.service();
        }
    }
}

public class SessionGatewayHandler extends GatewayHandler{
    @Override
    public void service() {
        System.out.println("进入SessionGatewayHandler拦截器。。。。");
        if (next!=null) {
            next.service();
        }
    }
}

public interface GatewayDao {
    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    GatewayEntity getGatewayEntity(Integer handlerId);
    /**
     * 获取第一个处理者
     * @return
     */
    GatewayEntity getFirstGatewayEntity();
}

public class GatewayDaoImpl implements GatewayDao {
    /**
     * 初始化，将枚举中配置的handler初始化到map中，方便获取
     */
    private static final Map<Integer, GatewayEntity> gatewayEntityMap = new HashMap<>();

    static {
        GatewayEnum[] values = GatewayEnum.values();
        for (GatewayEnum value : values) {
            GatewayEntity gatewayEntity = value.getGatewayEntity();
            gatewayEntityMap.put(gatewayEntity.getHandlerId(), gatewayEntity);
        }
    }

    @Override
    public GatewayEntity getGatewayEntity(Integer handlerId) {
        return gatewayEntityMap.get(handlerId);
    }
    @Override
    public GatewayEntity getFirstGatewayEntity() {
        for (Map.Entry<Integer, GatewayEntity> entry : gatewayEntityMap.entrySet()) {
            GatewayEntity value = entry.getValue();
            //  没有上一个handler的就是第一个
            if (value.getPreHandlerId() == null) {
                return value;
            }
        }
        return null;
    }
}

@Data
@AllArgsConstructor
public class GatewayEntity {
    private Integer handlerId;
    private String name;
    private String conference;
    private Integer preHandlerId;
    private Integer nextHandlerId;
}

public enum GatewayEnum {
    // handlerId, 拦截者名称，全限定类名，preHandlerId，nextHandlerId
    API_HANDLER(new GatewayEntity(1, "api接口限流", "com.matrix.chain.responsibility.factory.ApiLimitGatewayHandler", null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "黑名单拦截", "com.matrix.chain.responsibility.factory.BlacklistGatewayHandler", 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "用户会话拦截", "com.matrix.chain.responsibility.factory.SessionGatewayHandler", 2, null)),
    ;

    final GatewayEntity gatewayEntity;
    public GatewayEntity getGatewayEntity() {
        return gatewayEntity;
    }
    GatewayEnum(GatewayEntity gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }
}

public class Client {
    public static void main(String[] args) {
        GatewayHandler firstGatewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGatewayHandler.service();
    }
}
```

#### 3.3、第三个示例

通过责任链模式实现顺序检查多个业务流程，避免了多层if--else，方便扩展。

**1、UML**

![image-20230206105324386](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230206105324386.png)

**2、核心代码**

```java
@Data
@AllArgsConstructor
public class ProductCheckHandlerConfig {
    /**
     * 处理器Bean名称
     */
    private String handler;
    /**
     * 下一个处理器
     */
    private ProductCheckHandlerConfig next;
    /**
     * 是否降级
     */
    private Boolean down;
}

/**
 * 抽象处理器
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:39
 */
public abstract class AbstractCheckHandler {
    /**
     * 当前处理器持有下一个处理器的引用
     */
    @Getter
    @Setter
    protected AbstractCheckHandler nextHandler;
    /**
     * 处理器配置
     */
    @Setter
    @Getter
    protected ProductCheckHandlerConfig config;
    /**
     * 处理器执行方法
     * @param param
     * @return
     */
    public abstract Result handle(Product param);
    /**
     * 链路传递
     * @param param
     * @return
     */
    protected Result next(Product param) {
        //下一个链路没有处理器了，直接返回
        if (Objects.isNull(nextHandler)) {
            return Result.success();
        }

        //执行下一个处理器
        return nextHandler.handle(param);
    }
}

/**
 * 空值校验
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:47
 */
@Component
public class NullValueCheckHandler extends AbstractCheckHandler {
    @Override
    public Result handle(Product param) {
        System.out.println("空值校验 Handler 开始...");
        //降级：如果配置了降级，则跳过此处理器，执行下一个处理器
        if (super.getConfig().getDown()) {
            System.out.println("空值校验 Handler 已降级，跳过空值校验 Handler...");
            return super.next(param);
        }
        //参数必填校验
        if (Objects.isNull(param)) {
            return Result.failure(ErrorCode.PARAM_NULL_ERROR);
        }
        //SkuId商品主键参数必填校验
        if (Objects.isNull(param.getSkuId())) {
            return Result.failure(ErrorCode.PARAM_SKU_NULL_ERROR);
        }
        //Price价格参数必填校验
        if (Objects.isNull(param.getPrice())) {
            return Result.failure(ErrorCode.PARAM_PRICE_NULL_ERROR);
        }
        //Stock库存参数必填校验
        if (Objects.isNull(param.getStock())) {
            return Result.failure(ErrorCode.PARAM_STOCK_NULL_ERROR);
        }
        System.out.println("空值校验 Handler 通过...");
        //执行下一个处理器
        return super.next(param);
    }
}

/**
 * 价格处理器
 *
 * @author : cui_feng
 * @since : 2022-12-27 10:07
 */
@Component
public class PriceCheckHandler extends AbstractCheckHandler {
    @Override
    public Result handle(Product param) {
        System.out.println("价格校验 Handler 开始...");
        //非法价格校验
        boolean illegalPrice =  param.getPrice() <= 0;
        if (illegalPrice) {
            return Result.failure(ErrorCode.PARAM_PRICE_ILLEGAL_ERROR);
        }
        //其他校验逻辑...
        System.out.println("价格校验 Handler 通过...");
        //执行下一个处理器
        return super.next(param);
    }
}

/**
 * 库存处理器
 *
 * @author : cui_feng
 * @since : 2022-12-27 10:09
 */
@Component
public class StockCheckHandler extends AbstractCheckHandler {
    @Override
    public Result handle(Product param) {
        System.out.println("库存校验 Handler 开始...");
        //非法库存校验
        boolean illegalStock = param.getStock() < 0;
        if (illegalStock) {
            return Result.failure(ErrorCode.PARAM_STOCK_ILLEGAL_ERROR);
        }
        //其他校验逻辑..
        System.out.println("库存校验 Handler 通过...");
        //执行下一个处理器
        return super.next(param);
    }
}

/**
 * 客户端
 *
 * @author : cui_feng
 * @since : 2022-12-27 10:11
 */
@Component
public class HandlerClient {
    @Resource
    private Map<String, AbstractCheckHandler> handlerMap;

    public Result executeChain(ProductCheckHandlerConfig config, Product param) {
        AbstractCheckHandler handler = this.getHandler(config);
        if (handler == null) {
            return Result.failure("配置错误");
        }
        //执行处理器
        Result handlerResult = handler.handle(param);
        if (!handlerResult.isSuccess()) {
            System.out.println("HandlerClient 责任链执行失败返回：" + handlerResult.toString());
            return handlerResult;
        }
        return Result.success();
    }

    /**
     * 获取处理器
     * @param config
     * @return
     */
    private AbstractCheckHandler getHandler(ProductCheckHandlerConfig config) {
        //配置检查：没有配置处理器链路，则不执行校验逻辑
        if (Objects.isNull(config)) {
            return null;
        }
        //配置错误
        String handler = config.getHandler();
        if (!StringUtils.hasLength(handler)) {
            return null;
        }
        //配置了不存在的处理器
        AbstractCheckHandler abstractCheckHandler = handlerMap.get(config.getHandler());
        if (Objects.isNull(abstractCheckHandler)) {
            return null;
        }
        abstractCheckHandler.setConfig(config);
        //递归设置链路处理器
        abstractCheckHandler.setNextHandler(this.getHandler(config.getNext()));
        return abstractCheckHandler;
    }
}

/**
 * 商品，需要检查的类
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:36
 */
@Data
public class Product {
    /**
     * 商品SKU，唯一
     */
    private Long skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品图片路径
     */
    private String Path;
    /**
     * 价格
     */
    private Long price = 0L;
    /**
     * 库存
     */
    private Integer stock = 0;
}

/**
 * 返回结果
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:41
 */
@Data
public class Result {
    private String msg;
    private Integer code;
    private Boolean success = false;
    public static Result failure(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(500);
        return result;
    }
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }
    public Boolean isSuccess() {
        return success;
    }
}

/**
 * 错误码
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:49
 */
public class ErrorCode {
    public static String PARAM_NULL_ERROR = "参数空值错误";
    public static String PARAM_SKU_NULL_ERROR = "错误，SKU为空";
    public static String PARAM_PRICE_NULL_ERROR = "错误，价格为空";
    public static String PARAM_STOCK_NULL_ERROR = "错误，库存为空";
    public static String PARAM_PRICE_ILLEGAL_ERROR = "错误，价格不能小于等于零";
    public static String PARAM_STOCK_ILLEGAL_ERROR = "错误，库存不能小于零";
}


/**
 * 测试使用
 * @author : cui_feng
 * @since : 2022-12-27 10:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ComponentScan("com.matrix")
public class MainTest {

    @Resource
    HandlerClient handlerClient;

    /**
     * 获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
     * @return
     */
    private ProductCheckHandlerConfig getHandlerConfig() {
        //配置中心存储的配置
        String configJson = "{\"handler\":\"nullValueCheckHandler\",\"down\":true,\"next\":{\"handler\":\"priceCheckHandler\",\"next\":{\"handler\":\"stockCheckHandler\",\"next\":null}}}";
        //转成Config对象
        return JSON.parseObject(configJson, ProductCheckHandlerConfig.class);
    }

    @Test
    public void main() {
        Product p = new Product();
        //获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
        ProductCheckHandlerConfig handlerConfig = this.getHandlerConfig();
        //责任链：执行处理器链路
        Result executeChainResult = handlerClient.executeChain(handlerConfig, p);
        System.out.println(executeChainResult);
    }
}
```

### 四、总结

责任链模式很像异常的捕获和处理，当一个问题发生的时候，当前对象看一下自己是否能够处理，不能的话将问题抛给自己的上级去处理，但是要注意这里的上级不一定指的是继承关系的父类，这点和异常的处理是不一样的。所以可以这样说，当问题不能解决的时候，将问题交给另一个对象去处理，就这样一直传递下去直至当前对象找不到下线了，处理结束。在实际应用中，我们都是将解答能力最弱的类放到最前面，然后一点点加强，这样可以使得解答能力比较弱的类有机会去解答。如果让解答能力强的类直接去处理问题，能够处理就不回传给下一个了，当然有的类能力有限，有的类和其他类的能力有重叠部分，当然也有所有类都解决不了的问题。通过责任链，我们可以将问题与处理问题的对象分离出来，**特别适合用于不知道发生的问题到底是什么（有很多选择）但是又必须处理的情况（按照每个选择情况设计相应的处理类）**，这样就弱化了请求问题的人和回答问题的人的关系，如果不得不让发出请求的人知道处理请求的人，这样就不利于代码的复用。

使用场景：

- 多条件流程判断：权限控制
- ERP 系统流程审批：总经理、人事经理、项目经理
- Java 过滤器的底层实现 Filter
