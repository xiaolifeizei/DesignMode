package com.matrix.chain.responsibility.handler;

import com.matrix.chain.responsibility.entity.Product;
import com.matrix.chain.responsibility.entity.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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
