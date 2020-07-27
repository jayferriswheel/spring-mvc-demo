package com.carto.rpc;

/**
 * @author yangjie263
 * @date 2020/6/23 15:46
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
