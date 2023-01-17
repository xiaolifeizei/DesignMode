package com.matrix.strategy.one;

import lombok.Data;

/**
 * 环境
 *
 * @author : cui_feng
 * @since : 2023-01-17 13:24
 */
@Data
public class Context {

    private Strategy strategy;

    public void request() {
        strategy.request();
    }
}
