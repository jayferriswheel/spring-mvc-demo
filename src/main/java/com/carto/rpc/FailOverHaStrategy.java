package com.carto.rpc;

import java.util.List;

/**
 * 失败转移
 *
 * @author yangjie263
 * @date 2020/6/24 11:10
 */
public class FailOverHaStrategy {
    public void call() {
        // 1. 依据负载均衡策略，选择服务器

        // 成功就不处理

        // 不成功则重试
    }
}
