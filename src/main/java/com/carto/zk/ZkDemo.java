package com.carto.zk;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);


    public static void main(String[] args) throws Exception {
        String serverUrl = "zk-master.sst.blackfi.sh:2181";


//        ZooKeeper zooKeeper = new ZooKeeper(serverUrl, 5000, new Watcher() {
//            @Override
//            public void process(WatchedEvent watchedEvent) {
//                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
//                    countDownLatch.countDown();
//                    System.out.println("watchedEvent state : " + watchedEvent.getState());
//                } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
//
//                }
//            }
//        });
//
//        countDownLatch.await();
//        System.out.println("zooKeeper state : " + zooKeeper.getState());

//        zooKeeper.getChildren("/fsp", true);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(serverUrl)
                .retryPolicy(new ExponentialBackoffRetry(100, 3))
                .build();

        curatorFramework.start();
        curatorFramework.getChildren();


        curatorFramework.inTransaction().check();

    }
}
