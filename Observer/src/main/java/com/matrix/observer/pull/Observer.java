package com.matrix.observer.pull;

/**
 * @author : cui_feng
 * @since : 2023-01-12 11:07
 */
public interface Observer {

    /**
     * 更新接口
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    void update(Subject subject);
}
