package com.carto.consistent;

public class VirtualNode<T extends Node> implements Node {
    final T physicalNode;
    final int replicaIndex;

    public VirtualNode(T physicalNode, int replicaIndex) {
        this.physicalNode = physicalNode;
        this.replicaIndex = replicaIndex;
    }

    @Override
    public String getKey() {
        return physicalNode.getKey() + "-" + replicaIndex;
    }

    /**
     * @param pNode 物理节点
     * @return 判断该虚拟节点是否是属于该物理节点
     */
    public boolean isVirtualNodeOf(T pNode) {
        return pNode.getKey().equals(physicalNode.getKey());
    }

    public T getPhysicalNode() {
        return physicalNode;
    }
}
