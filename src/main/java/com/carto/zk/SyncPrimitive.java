package com.carto.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class SyncPrimitive implements Watcher {
    static ZooKeeper zk = null;
    static Integer mutex;

    String root;

    public static void main(String[] args) {
        String address = "zk-master.sst.blackfi.sh:2181";
        SyncPrimitive primitive = new SyncPrimitive(address);
    }

    SyncPrimitive(String address) {
        if (zk == null) {
            try {
                zk = new ZooKeeper(address, 3000, (Watcher) this);
                mutex = new Integer(-1);
                System.out.println("Finished starting ZK: " + zk);
            } catch (IOException e) {
                System.out.println(e.toString());
                zk = null;
            }
        }
    }

    @Override
    public void process(WatchedEvent event) {

    }
}
