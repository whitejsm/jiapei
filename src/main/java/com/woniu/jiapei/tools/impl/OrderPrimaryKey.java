/**
 * order主键生成测试
 * @auther ytmzz
 * @since 2020/06/10
 */
package com.woniu.jiapei.tools.impl;

import com.woniu.jiapei.tools.IPrimaryKey;

import java.util.UUID;

public class OrderPrimaryKey implements IPrimaryKey {
    @Override
    public String generatePrimaryKey() {
        return UUID.randomUUID().toString();
    }
}
