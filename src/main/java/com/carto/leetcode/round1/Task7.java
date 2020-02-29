package com.carto.leetcode.round1;

public class Task7 {

    public int reverse(int x) {
        int flag = x > 0 ? 1 : -1;

        // 第一个重点，确定位数
        int num = x > 0 ? x : -x;


        int result = 0;

        while (num > 0) {
            int i = num % 10;
            // 这里是出错的一个经典地方，就是这样相加已经超标了，不能这样
            if (result * 10 + i > Integer.MAX_VALUE) {
                return 0;
            } else {
                result = result * 10 + i;
            }

            num = num / 10;
        }

        return result * flag;
    }

}
