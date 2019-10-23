package com.carto.distribute.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class ZooLock implements Watcher {

    private void demo() throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().build();

        // 可重入的排它锁 使用了一个map保存了获取到的锁信息
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "lock-1");
        interProcessMutex.acquire();
        interProcessMutex.release(); // 删除就直接删除node

        // Shared Lock -- 看不懂
        InterProcessSemaphoreMutex semaphoreMutex = new InterProcessSemaphoreMutex(curatorFramework, "lock-2");
        semaphoreMutex.acquire();
        semaphoreMutex.release();

        // 写锁类似可重入排它锁，读锁则是修改了，只要前面没有write，都可以读
        InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(curatorFramework, "lock-3");
        readWriteLock.readLock().acquire();
        readWriteLock.writeLock().acquire();
    }

    @Override
    public void process(WatchedEvent event) {
        // 处理watch事件
    }
}
