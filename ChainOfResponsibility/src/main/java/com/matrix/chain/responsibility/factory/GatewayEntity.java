package com.matrix.chain.responsibility.factory;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : cui_feng
 * @since : 2023-01-29 09:34
 */
@Data
@AllArgsConstructor
public class GatewayEntity {

    private Integer handlerId;

    private String name;

    private String conference;

    private Integer preHandlerId;

    private Integer nextHandlerId;
}
