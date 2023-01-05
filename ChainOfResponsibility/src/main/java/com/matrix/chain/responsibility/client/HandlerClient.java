package com.matrix.chain.responsibility.client;

import com.matrix.chain.responsibility.handler.AbstractCheckHandler;
import com.matrix.chain.responsibility.entity.Product;
import com.matrix.chain.responsibility.entity.Result;
import com.matrix.chain.responsibility.handler.ProductCheckHandlerConfig;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

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
