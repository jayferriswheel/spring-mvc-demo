package com.carto.rpc;

/**
 * rpc
 *
 * @author yangjie263
 * @date 2020/6/23 15:47
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
