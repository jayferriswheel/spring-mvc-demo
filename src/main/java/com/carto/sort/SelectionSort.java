package com.carto.sort;

import com.carto.util.ArrayUtils;

/**
 * 每次选取最小的
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        selectionSort(nums);
        ArrayUtils.printArray(nums);
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min_idx = i; // 这里是index啊，注意所有排序，都是调换swap，而不是替换
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min_idx] > nums[j]) {
                    min_idx = j;
                }
            }
            ArrayUtils.swap(nums, min_idx, i);
        }
    }
}
