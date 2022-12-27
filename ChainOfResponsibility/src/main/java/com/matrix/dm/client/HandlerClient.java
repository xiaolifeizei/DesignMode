package com.matrix.dm.client;

import com.matrix.dm.entity.Product;
import com.matrix.dm.entity.Result;
import com.matrix.dm.handler.AbstractCheckHandler;

/**
 * 客户端
 *
 * @author : cui_feng
 * @since : 2022-12-27 10:11
 */
public class HandlerClient {

    public static Result executeChain(AbstractCheckHandler handler, Product param) {
        //执行处理器
        Result handlerResult = handler.handle(param);
        if (!handlerResult.isSuccess()) {
            System.out.println("HandlerClient 责任链执行失败返回：" + handlerResult.toString());
            return handlerResult;
        }
        return Result.success();
    }
}
