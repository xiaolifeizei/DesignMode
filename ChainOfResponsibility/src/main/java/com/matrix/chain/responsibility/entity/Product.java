package com.matrix.chain.responsibility.entity;

import lombok.Data;

/**
 * 商品
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:36
 */
@Data
public class Product {

    /**
     * 商品SKU，唯一
     */
    private Long skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品图片路径
     */
    private String Path;
    /**
     * 价格
     */
    private Long price = 0L;
    /**
     * 库存
     */
    private Integer stock = 0;
}
