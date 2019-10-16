package com.carto.zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;

public class MasterSelector {
    private ZkClient zkClient;

    private UserCenter server;
    private UserCenter master;


    public MasterSelector(UserCenter userCenter) {
        IZkDataListener dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        };
    }


    public void start() {
    }

    public void stop() {
    }

    private void chooseMaster() {

        try {
            zkClient.createEphemeral("master", server);
            master = server;
            System.out.println("我已经成为master了");
        } catch (ZkNodeExistsException e) {
        }
    }

    private boolean isMaster() {
        UserCenter userCenter = zkClient.readData("master");

        return false;
    }
}
