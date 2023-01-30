package com.matrix.chain.responsibility.factory;

/**
 * @author : cui_feng
 * @since : 2023-01-29 10:07
 */
public class ApiLimitGatewayHandler extends GatewayHandler{

    @Override
    public void service() {
        System.out.println("进入ApiLimitGatewayHandler拦截器。。。。");

        if (next!=null) {
            next.service();
        }
    }
}
