package com.carto.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;

import java.nio.ByteBuffer;
import java.util.List;

public class Consumer extends SyncPrimitive {
    Consumer(String address) {
        super(address);
    }

    int consume() throws KeeperException, InterruptedException {
        int retvalue = -1;
        Stat stat = null;

        while (true) {
            synchronized (mutex) {
                List<String> list = zk.getChildren(root, true);
                if (list.size() == 0) {
                    System.out.println("Going to wait");
                    mutex.wait();
                } else {
                    Integer min = new Integer(list.get(0).substring(7));
                    for (String s : list) {
                        Integer tempValue = new Integer(s.substring(7));
                        if (tempValue < min) min = tempValue;
                    }
                    System.out.println("Temporary value : " + root + "/element" + min);
                    byte[] b = zk.getData(root + "/element" + min, false, stat);
                    zk.delete(root + "element/" + min, 0);

                    ByteBuffer buffer = ByteBuffer.wrap(b);
                    retvalue = buffer.getInt();

                    return retvalue;
                }
            }
        }
    }
}
