package com.matrix.chain.responsibility.factory;

/**
 * @author : cui_feng
 * @since : 2023-01-29 10:08
 */
public class SessionGatewayHandler extends GatewayHandler{
    @Override
    public void service() {
        System.out.println("进入SessionGatewayHandler拦截器。。。。");

        if (next!=null) {
            next.service();
        }
    }
}
