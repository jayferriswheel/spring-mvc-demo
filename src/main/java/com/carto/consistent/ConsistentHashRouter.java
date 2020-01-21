package com.carto.consistent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRouter<T extends Node> {
    private final SortedMap<Long, VirtualNode<T>> ring = new TreeMap<>();
    private final HashFunction hashFunction;

    public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount) {
        this(pNodes, vNodeCount, new MD5Hash());
    }

    public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount, HashFunction hashFunction) {
        if (hashFunction == null) {
            throw new NullPointerException("hash function is null");
        }
        this.hashFunction = hashFunction;
        if (pNodes != null) {
            for (T pNode : pNodes) {
                addNode(pNode, vNodeCount);
            }
        }
    }

    /**
     * @param pNode      physical node needs added to hash ring 这个加入的是真实节点
     * @param vNodeCount the number of virtual node of the physical node. Value should be greater
     *                   than or equals to 0
     */
    public void addNode(T pNode, int vNodeCount) {
        if (vNodeCount < 0)
            throw new IllegalArgumentException("illegal virtual node counts : " + vNodeCount);
        int existingReplicas = getExistingReplicas(pNode);
        for (int i = 0; i < vNodeCount; i++) {
            // 已有的虚拟节点，代表index是第几个
            VirtualNode<T> vNode = new VirtualNode<>(pNode, i + existingReplicas);
            ring.put(hashFunction.hash(vNode.getKey()), vNode);
        }
    }

    public void removeNode(T pNode) {
        Iterator<Long> it = ring.keySet().iterator();
        while (it.hasNext()) {
            Long key = it.next();
            // 这个index是不是会错乱啊
            VirtualNode<T> virtualNode = ring.get(key);
            if (virtualNode.isVirtualNodeOf(pNode)) {
                it.remove();
            }
        }
    }

    public T routeNode(String objectKey) {
        if (ring.isEmpty()) {
            return null;
        }
        Long hashVal = hashFunction.hash(objectKey);
        // 比这个key大的map
        SortedMap<Long, VirtualNode<T>> tailMap = ring.tailMap(hashVal);
        Long nodeHashVal = !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
        return ring.get(nodeHashVal).getPhysicalNode(); // 虚拟节点是可以直达真实节点的
    }


    private int getExistingReplicas(T pNode) {
        int replicas = 0;
        for (VirtualNode<T> vNode : ring.values()) {
            if (vNode.isVirtualNodeOf(pNode)) {
                replicas++;
            }
        }
        return replicas;
    }


    private static class MD5Hash implements HashFunction {
        MessageDigest instance;

        public MD5Hash() {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
        }

        @Override
        public long hash(String key) {
            instance.reset();
            instance.update(key.getBytes());
            byte[] digest = instance.digest();

            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }
            return h;
        }
    }
}
