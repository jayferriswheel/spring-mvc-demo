package com.carto.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆OOM
 *
 * @author yangjie263
 * @date 2020/6/30 15:00
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
