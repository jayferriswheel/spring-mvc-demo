package com.carto.rpc;

import java.util.HashMap;

/**
 * @author yangjie263
 * @date 2020/6/24 11:01
 */
public class IpMap {
    // 待路由的 Ip 列表，Key 代表 Ip，Value 代表该 Ip 的权重
    public static HashMap<String, Integer> serverWeightMap =
            new HashMap<String, Integer>();

    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        // 权重为 4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        // 权重为 3
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        // 权重为 2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }
}
