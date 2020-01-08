package com.carto.concurrent;

import com.google.common.collect.Lists;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConcurrentDemo {
    // 多个线程同时执行，哪个先回来，先处理哪个，处理所有线程为结束
    public static void main(String[] args) {
        new ConcurrentDemo().demo();
    }

    private void demo() {
        List<String> ids = Lists.newArrayList("1", "s", "19", "18", "17", "16", "15", "14", "13", "12", "11");
//        ids.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        List<List<String>> lists = Lists.partition(ids, 5);
        List<CompletableFuture<HashMap<String, String>>> futures = lists.stream()
                .map(list -> CompletableFuture.supplyAsync(new DemoSupplier(list)))
                .collect(Collectors.toList());

        HashMap<String, String> result = new HashMap<>();
        futures.stream()
                .map(CompletableFuture::join)
                .forEach(item -> {
                    if (!CollectionUtils.isEmpty(item)) {
                        result.putAll(item);
                    }
                });

        System.out.println(result.size());
    }

    private class DemoSupplier implements Supplier<HashMap<String, String>> {
        private List<String> list;

        DemoSupplier(List<String> list) {
            this.list = list;
        }

        @Override
        public HashMap<String, String> get() {
            list.forEach(e->Integer.parseInt(e));
            HashMap<String, String> map = new HashMap<>();
            map.put(String.valueOf(RandomUtils.nextInt(10)), "1");
            return map;
        }
    }
}
