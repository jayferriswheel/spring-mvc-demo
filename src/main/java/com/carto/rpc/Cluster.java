package com.carto.rpc;

/**
 * 集群：这个集群指的是服务提供者集群
 * 职责：
 * 1. 负载均衡
 * 2. 高可用：rpc请求失败时，如何处理？ failover、failfast、failsafe、failback、forking、broadcast
 * 3. 路由
 * <p>
 * nginx属于服务端负载均衡，因为请求已经打到了服务端，需要进行分配了
 * <p>
 * 在 RPC 调用中，客户端持有所有的服务端节点引用，自行通过负载均衡算法选择一个节点进行访问，这便是客户端负载均衡。
 *
 * @author yangjie263
 * @date 2020/6/24 10:53
 */
public interface Cluster {
    void setUrl(URL url);

    // 指定负载均衡策略
    void setLoadBanlance();

    // 指定高可用策略
    void setHAStrategy();


}
