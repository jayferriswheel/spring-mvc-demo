package com.carto.sort;

import com.carto.util.ArrayUtils;

public class HeapSort {
    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7, 9, 100, 293};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // 构建大顶堆？ 因为它的左子节点是n-1，右子节点为n，不存在。满足了一个初始条件。
        // 其实是因为，最大堆只需要父节点大于两个子节点，不需要两个子节点还有大小顺序
        // value in a parent node is greater(or smaller) than the values in its two children nodes.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            ArrayUtils.swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // l和r保证的是最大，相对顺序无影响
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            ArrayUtils.swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }
}
