package com.matrix.dm.constant;

/**
 * 错误码
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:49
 */
public class ErrorCode {

    public static String PARAM_NULL_ERROR = "参数空值错误";

    public static String PARAM_SKU_NULL_ERROR = "错误，SKU为空";

    public static String PARAM_PRICE_NULL_ERROR = "错误，价格为空";

    public static String PARAM_STOCK_NULL_ERROR = "错误，库存为空";

    public static String PARAM_PRICE_ILLEGAL_ERROR = "错误，价格不能小于等于零";

    public static String PARAM_STOCK_ILLEGAL_ERROR = "错误，库存不能小于零";
}
