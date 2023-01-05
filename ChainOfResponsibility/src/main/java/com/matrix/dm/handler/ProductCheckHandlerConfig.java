package com.matrix.dm.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 处理器配置类
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:45
 */
@Data
@AllArgsConstructor
public class ProductCheckHandlerConfig {

    /**
     * 处理器Bean名称
     */
    private String handler;
    /**
     * 下一个处理器
     */
    private ProductCheckHandlerConfig next;
    /**
     * 是否降级
     */
    private Boolean down;

}
