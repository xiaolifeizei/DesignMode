package com.matrix.chain.responsibility.handler.impl;

import com.matrix.chain.responsibility.handler.AbstractCheckHandler;
import com.matrix.chain.responsibility.constant.ErrorCode;
import com.matrix.chain.responsibility.entity.Product;
import com.matrix.chain.responsibility.entity.Result;
import org.springframework.stereotype.Component;

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
