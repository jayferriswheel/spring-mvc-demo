package com.carto.sort.task1;

import com.carto.util.ArrayUtils;

public class BubbleSort {
    // 错错错
    private static void bubbleSort(int[] nums) {
        int max = nums.length;
        for (int i = max; i >= max; i++) {
            int max_index = i;
            for (int j = i + 1; j < max; j++) {
                if (nums[j] > nums[max_index]) {
                    max_index = j;
                }
            }
            ArrayUtils.swap(nums, i, max_index);
            max--;
        }
    }
}
