package com.carto.util;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
//        HashMap<HashUser, String> hashMap = new HashMap<>();
//        HashUser user = new HashUser();
//        hashMap.put(user, "111");
//        hashMap.put(user, "111");
//        hashMap.put(null, "111");
//        hashMap.get(user);

//        System.out.println(String.format("%010d", 234));
//        System.out.println(String.format("%010d", 1234567890));


//        List<String> ids = Lists.newArrayList("1", "10", "19", "18", "17", "16", "15", "14", "13", "12", "11");
//        List<List<String>> lists = Lists.partition(ids, 5);
//        for (List<String> list : lists) {
//            PrintUtils.print(list);
//        }

//        CompletableFuture
        Map<String, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> channelIds = (HashSet<Integer>) map.computeIfAbsent("kk", k ->
                new HashSet<Integer>()
        );
        channelIds.add(11);
        System.out.println(map.get("kk"));
    }
}