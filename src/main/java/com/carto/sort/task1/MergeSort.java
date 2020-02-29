package com.carto.sort.task1;

import com.carto.util.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createIntArray(10);
        ArrayUtils.printArray(nums);
        sort(nums, 0, nums.length - 1);
        ArrayUtils.printArray(nums);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] nums1 = new int[mid - l + 1];
        int[] nums2 = new int[r - mid];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[l + i]; // 这里改变了l的值啊，这是不能改的
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[l++] = nums1[i];
                i++;
            } else {
                nums[l++] = nums2[j];
                j++;
            }
        }

        while (i < nums1.length) {
            nums[l++] = nums1[i++];
        }

        while (j < nums2.length) {
            nums[l++] = nums2[j++];
        }
    }

    private static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }
}
