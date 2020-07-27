package com.carto.rpc;

import com.alibaba.dubbo.registry.NotifyListener;

import java.net.URL;
import java.util.List;

/**
 * @author yangjie263
 * @date 2020/6/24 10:40
 */
public interface DiscoveryService {
    // 订阅服务
    void subscribe(URL url, NotifyListener listener);

    // 取消订阅
    void unsubscribe(URL url, NotifyListener listener);

    // 发现的服务列表
    List<URL> discover(URL url);
}
