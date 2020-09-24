package com.example.dxpzk.enums;

import java.io.Serializable;

/**
 * @author zk
 * @since 2020-03-16
 */
public interface ErrorCode extends Serializable {

    /**
     * 错误码
     *
     * @return
     */
    String getCode();

    /**
     * 错误信息
     *
     * @return
     */
    String getMsg();
}