package com.carto.sort.task1;

import com.carto.util.ArrayUtils;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        sort(nums, 0, nums.length - 1);
        ArrayUtils.printArray(nums);
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;

        // 重点在于将小的往前挪就行
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                i++;
                ArrayUtils.swap(nums, i, j);
            }
        }

        ArrayUtils.swap(nums, i + 1, r);

        return i + 1;
    }

    private static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = partition(nums, l, r);
            sort(nums, 0, partition - 1);
            sort(nums, partition + 1, r);
        }
    }

}
