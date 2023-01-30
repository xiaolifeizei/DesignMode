package com.matrix.chain.responsibility.factory;

/**
 * @author : cui_feng
 * @since : 2023-01-29 09:37
 */
public interface GatewayDao {

    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    GatewayEntity getGatewayEntity(Integer handlerId);

    /**
     * 获取第一个处理者
     * @return
     */
    GatewayEntity getFirstGatewayEntity();
}
