package com.carto.util;

import java.util.Random;

public class ArrayUtils {
    private static Random random = new Random();

    public static void main(String[] args) {

    }

    public static int[] createIntArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }

    /* A utility function to print array of size n */
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
