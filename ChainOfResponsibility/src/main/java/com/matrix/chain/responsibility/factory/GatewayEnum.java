package com.matrix.chain.responsibility.factory;

/**
 * 定义枚举来维护处理器的关系
 *
 * @author : cui_feng
 * @since : 2023-01-29 09:33
 */
public enum GatewayEnum {

    // handlerId, 拦截者名称，全限定类名，preHandlerId，nextHandlerId
    API_HANDLER(new GatewayEntity(1, "api接口限流", "com.matrix.chain.responsibility.factory.ApiLimitGatewayHandler", null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "黑名单拦截", "com.matrix.chain.responsibility.factory.BlacklistGatewayHandler", 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "用户会话拦截", "com.matrix.chain.responsibility.factory.SessionGatewayHandler", 2, null)),
    ;

    final GatewayEntity gatewayEntity;

    public GatewayEntity getGatewayEntity() {
        return gatewayEntity;
    }

    GatewayEnum(GatewayEntity gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }
}
