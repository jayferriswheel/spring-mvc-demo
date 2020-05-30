package com.carto.leetcode.round1;

import java.util.PriorityQueue;

/**
 * 堆在java中表示：大顶堆；小顶堆；
 */
public class Task215 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
