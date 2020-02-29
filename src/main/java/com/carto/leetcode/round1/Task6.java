package com.carto.leetcode.round1;

public class Task6 {

    public static String convert(String s, int numRows) {
        String result = "";
        if (s == null || s.equals("")) return result;
        if (numRows == 1) return s;
        int cycle = 2 * numRows - 2; // 计数周期
        for (int k = 1; k <= numRows; k++) {
            for (int i = 0; i < s.length(); i++) {
                // 1. 计算出来在周期中处于第几位
                int j = i % cycle;
                int row;
                if (j + 1 < numRows) {
                    row = j + 1;
                } else {
                    row = numRows - (j + 1 - numRows);
                }
                if (k == row) {
                    result += s.charAt(i);
                }
            }
        }
        return result;
        // 解法2中一个周期除了首尾，中间的只会出现2次，且位置是可以计算出来的
    }
}
