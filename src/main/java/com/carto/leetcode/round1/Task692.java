package com.carto.leetcode.round1;

import java.util.*;

public class Task692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (countMap.get(words[i]) == null) {
                countMap.put(words[i], 1);
            } else {
                countMap.put(words[i], countMap.get(words[i]) + 1);
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<String>((s1, s2) -> {
            int res = countMap.get(s2) - countMap.get(s1);
            if (res != 0) {
                return res;
            } else {
                return compare(s1, s2);
            }
        });

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            queue.add(entry.getKey());
        }


        List<String> list = new ArrayList<>();
        for (int t = 0; t < k; t++) {
            list.add(queue.poll());
        }
        return list;
    }

    private int compare(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                return s1.charAt(i) - s2.charAt(j);
            }
        }

        if (i < s1.length()) {
            return 1;
        }

        if (j < s2.length()) {
            return -1;
        }

        return 0;
    }
}
