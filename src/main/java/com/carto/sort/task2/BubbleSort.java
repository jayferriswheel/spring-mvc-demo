package com.carto.sort.task2;

import com.carto.util.ArrayUtils;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        ArrayUtils.printArray(nums);
        bubbleSort(nums);
        ArrayUtils.printArray(nums);
    }


    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtils.swap(nums, j, j + 1);
                }
            }
        }
    }

}
