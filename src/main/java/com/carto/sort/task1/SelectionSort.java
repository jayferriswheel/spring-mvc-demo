package com.carto.sort.task1;

import com.carto.util.ArrayUtils;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        ArrayUtils.printArray(nums);
        selectionSort(nums);
        ArrayUtils.printArray(nums);
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(nums, minIndex, i);
        }
    }
}
