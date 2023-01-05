package com.matrix.chain.responsibility.handler.impl;

import com.matrix.chain.responsibility.constant.ErrorCode;
import com.matrix.chain.responsibility.entity.Result;
import com.matrix.chain.responsibility.handler.AbstractCheckHandler;
import com.matrix.chain.responsibility.entity.Product;
import org.springframework.stereotype.Component;

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
