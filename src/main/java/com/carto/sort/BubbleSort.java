package com.carto.sort;

import com.carto.util.ArrayUtils;

/**
 * key point:
 * 1. 第一趟下来，确定的不是第一个数，而是最后一个
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        bubbleSort(nums);
        ArrayUtils.printArray(nums);
    }

    // 错了，每次都是确定最后一个数，你这样每次确定的是第一个数，不是啊，，冒泡是大的往后冒
    private static void bubbleSortWrong(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


}
