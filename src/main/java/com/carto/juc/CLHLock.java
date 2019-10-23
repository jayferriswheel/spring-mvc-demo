package com.carto.juc;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH: 采用自旋来解决锁的问题
 * <p>
 * 优势：入队、出队速度快，不需要锁
 * <p>
 * AQS改进：
 * 1. 增加next指针
 * 2. 添加了状态
 */
public class CLHLock {

    AtomicReference<QNode> tail = new AtomicReference<QNode>(new QNode());
    // 注意这是以我自己这个线程来讲的
    ThreadLocal<QNode> myPredThreadLocal; // 上一个节点
    ThreadLocal<QNode> myNodeThreadLocal; // 当前节点

    public static class QNode {
        public volatile boolean locked = false;
    }

    public CLHLock() {
        myNodeThreadLocal = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
        myPredThreadLocal = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return null;
            }
        };
    }

    public void lock() {
        QNode qnode = myNodeThreadLocal.get();
        qnode.locked = true;
        // 入队并获取前一个节点
        QNode pred = tail.getAndSet(qnode);
        myPredThreadLocal.set(pred);
        while (pred.locked) {
            //非阻塞算法
        }
        // 此处获取到锁，可以执行了
    }

    public void unlock() {
        QNode qnode = myNodeThreadLocal.get();
        qnode.locked = false;
        myNodeThreadLocal.set(myPredThreadLocal.get());
    }
}
