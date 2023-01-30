package com.matrix;

import com.alibaba.fastjson2.JSON;
import com.matrix.chain.responsibility.spring.client.HandlerClient;
import com.matrix.chain.responsibility.spring.entity.Product;
import com.matrix.chain.responsibility.spring.entity.Result;
import com.matrix.chain.responsibility.spring.handler.ProductCheckHandlerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
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
