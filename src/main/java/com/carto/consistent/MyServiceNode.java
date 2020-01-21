package com.carto.consistent;

import java.util.Arrays;

public class MyServiceNode implements Node {
    private final String idc;
    private final String ip;
    private final int port;

    public MyServiceNode(String idc, String ip, int port) {
        this.idc = idc;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String getKey() {
        return idc + "-" + ip + ":" + port;
    }

    @Override
    public String toString() {
        return getKey();
    }

    public static void main(String[] args) {
        MyServiceNode node1 = new MyServiceNode("IDC1", "127.0.0.1", 8080);
        MyServiceNode node2 = new MyServiceNode("IDC1", "127.0.0.1", 8081);
        MyServiceNode node3 = new MyServiceNode("IDC1", "127.0.0.1", 8082);
        MyServiceNode node4 = new MyServiceNode("IDC1", "127.0.0.1", 8083);

        ConsistentHashRouter<MyServiceNode> consistentHashRouter = new ConsistentHashRouter<>(Arrays.asList(node1, node2, node3, node4), 10);

        String requestIp1 = "192.168.0.1";
        String requestIp2 = "192.168.0.2";
        String requestIp3 = "192.168.0.3";
        String requestIp4 = "192.168.0.4";
        String requestIp5 = "192.168.0.5";

        goRoute(consistentHashRouter, requestIp1, requestIp2, requestIp3, requestIp4, requestIp5);

        MyServiceNode node5 = new MyServiceNode("IDC2", "127.0.0.1", 8080);//put new service online
        System.out.println("-------------putting new node online " + node5.getKey() + "------------");
        consistentHashRouter.addNode(node5, 10);

        goRoute(consistentHashRouter, requestIp1, requestIp2, requestIp3, requestIp4, requestIp5);

        consistentHashRouter.removeNode(node3);
        System.out.println("-------------remove node online " + node3.getKey() + "------------");
        goRoute(consistentHashRouter, requestIp1, requestIp2, requestIp3, requestIp4, requestIp5);
    }

    private static void goRoute(ConsistentHashRouter<MyServiceNode> consistentHashRouter, String... requestIps) {
        for (String requestIp : requestIps) {
            System.out.println(requestIp + " is route to " + consistentHashRouter.routeNode(requestIp));
        }
    }
}
