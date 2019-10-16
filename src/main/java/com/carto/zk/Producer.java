package com.carto.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

import java.nio.ByteBuffer;

public class Producer extends SyncPrimitive {

    Producer(String address) {
        super(address);
    }

    boolean produce(int i) throws KeeperException, InterruptedException {
        ByteBuffer b = ByteBuffer.allocate(4);
        byte[] value;

        b.putInt(i);
        value = b.array();

        zk.create(root + "/element", value, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        return true;
    }

}
