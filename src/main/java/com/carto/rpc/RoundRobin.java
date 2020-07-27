package com.carto.rpc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yangjie263
 * @date 2020/6/24 11:02
 */
public class RoundRobin {
    private static Integer pos = 0;

    public static String getServer() {
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<>();
        keyList.addAll(keySet);
        String server = null;
        synchronized (pos) {
            if (pos > keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }

        return server;
    }
}
