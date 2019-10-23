package com.carto.sort;

import com.carto.util.ArrayUtils;

/**
 * key point:
 * 1. 中间点计算方法，需要避免溢出
 */
public class BinaryFind {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        System.out.println(find(nums, 3));
        System.out.println(commonBinarySearch(nums, 3));
    }


    private static int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return binaryFind(nums, left, right, target);
    }


    private static int binaryFind(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int middle = left + (right - left) / 2;
        if (nums[middle] == target) return middle;
        if (nums[middle] > target) {
            return binaryFind(nums, left, middle - 1, target);
        } else {
            return binaryFind(nums, middle + 1, right, target);
        }
    }

    private static int commonBinarySearch(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > key) {
                right = middle - 1;
            } else if (nums[middle] < key) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
