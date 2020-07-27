package com.carto.rpc;

import java.net.URL;
import java.util.Collection;

/**
 * 注册中心
 *
 * 感知服务下线：
 * 1. zookeeper临时节点
 * 2. 主动下线推送 + 心跳检测
 *
 * @author yangjie263
 * @date 2020/6/24 10:37
 */
public interface RegistryService {
    // 向注册中心注册服务
    void register(URL url);

    // 从注册中心摘除服务
    void unregister(URL url);

    // 将服务设置为可用
    void available(URL url);

    // 将服务设置为不可用
    void unavailable(URL url);

    // 获取已注册服务的集合
    Collection<URL> getRegisteredServiceUrls();
}
