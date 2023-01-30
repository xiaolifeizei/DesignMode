package com.matrix.chain.responsibility.factory;

import lombok.Setter;

/**
 * @author : cui_feng
 * @since : 2023-01-29 10:02
 */
public abstract class GatewayHandler {

    @Setter
    protected GatewayHandler next;

    public abstract void service();
}
