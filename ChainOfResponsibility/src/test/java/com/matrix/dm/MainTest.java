package com.matrix.dm;

import com.alibaba.fastjson2.JSON;
import com.matrix.dm.client.HandlerClient;
import com.matrix.dm.entity.Product;
import com.matrix.dm.entity.Result;
import com.matrix.dm.handler.AbstractCheckHandler;
import com.matrix.dm.handler.ProductCheckHandlerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @author : cui_feng
 * @since : 2022-12-27 10:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ComponentScan("com.matrix")
public class MainTest {

    @Resource
    private Map<String, AbstractCheckHandler> handlerMap;

    /**
     * 参数校验：责任链模式
     * @param param
     * @return
     */
    private Result paramCheck(Product param) {

        //获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
        ProductCheckHandlerConfig handlerConfig = this.getHandlerConfigFile();

        //获取处理器
        AbstractCheckHandler handler = this.getHandler(handlerConfig);

        //责任链：执行处理器链路
        Result executeChainResult = HandlerClient.executeChain(handler, param);
        if (!executeChainResult.isSuccess()) {
            System.out.println("创建商品 失败...");
            return executeChainResult;
        }

        //处理器链路全部成功
        return Result.success();
    }

    /**
     * 获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
     * @return
     */
    private ProductCheckHandlerConfig getHandlerConfigFile() {
        //配置中心存储的配置
        String configJson = "{\"handler\":\"nullValueCheckHandler\",\"down\":true,\"next\":{\"handler\":\"priceCheckHandler\",\"next\":{\"handler\":\"stockCheckHandler\",\"next\":null}}}";
        //转成Config对象
        ProductCheckHandlerConfig handlerConfig = JSON.parseObject(configJson, ProductCheckHandlerConfig.class);
        return handlerConfig;
    }

    /**
     * 获取处理器
     * @param config
     * @return
     */
    private AbstractCheckHandler getHandler (ProductCheckHandlerConfig config) {
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

        //处理器设置配置Config
        abstractCheckHandler.setConfig(config);

        //递归设置链路处理器
        abstractCheckHandler.setNextHandler(this.getHandler(config.getNext()));

        return abstractCheckHandler;
    }

    private Result saveProduct(Product product) {
        return Result.success();
    }

    public Result createProduct(Product param) {
        //参数校验，使用责任链模式
        Result paramCheckResult = this.paramCheck(param);
        if (!paramCheckResult.isSuccess()) {
            return paramCheckResult;
        }

        //创建商品
        return this.saveProduct(param);
    }

    @Test
    public void main() {
        Product p = new Product();
        Result result = createProduct(p);
        System.out.println(result);
    }
}
