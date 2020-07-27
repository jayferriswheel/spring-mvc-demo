package com.carto.rpc;

import java.util.Map;

/**
 * @author yangjie263
 * @date 2020/6/24 10:44
 */
public class URL {
    private String protocol;
    private String host;
    private int port;
    private String path;
    private Map<String, String> parameters;
    //transient无需序列化；volatile保证可见性
    private volatile transient Map<String, Number> numbers;
}
