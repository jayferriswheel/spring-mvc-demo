package com.carto.zk;

import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class DataMonitor implements Watcher, StatCallback {
    boolean dead;
    DataMonitorListener listener;
    String znode;
    ZooKeeper zk;
    Watcher chainedWatcher;

    public interface DataMonitorListener {
        void exists(byte data[]);

        void closing(int rc);
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean exists = false;
        switch (rc) {
            case Code.Ok:
                exists = true;
                break;
        }

        byte b[] = null;
        if (exists) {
            try {
                b = zk.getData(znode, false, null);
            } catch (InterruptedException e) {
                return;
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        if (event.getType() == Event.EventType.None) {
            switch (event.getState()) {
                case SyncConnected:
                    break;
                case Expired:
                    dead = true;
                    break;
            }
        } else {
            if (path != null && path.equals(znode)) {
                zk.exists(znode, true, this, null);
            }
        }

        if (chainedWatcher != null) {
            chainedWatcher.process(event);
        }
    }


}
