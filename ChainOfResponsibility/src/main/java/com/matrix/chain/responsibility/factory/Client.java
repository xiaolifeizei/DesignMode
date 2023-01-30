package com.matrix.chain.responsibility.factory;

/**
 * @author : cui_feng
 * @since : 2023-01-29 09:38
 */
public class Client {

    public static void main(String[] args) {
        GatewayHandler firstGatewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGatewayHandler.service();
    }
}
