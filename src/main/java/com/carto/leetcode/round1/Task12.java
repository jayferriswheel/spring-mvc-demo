package com.carto.leetcode.round1;

public class Task12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int i = num % 10;
        sb.append(toStr(i));
        num = num / 10;

        while (num / 10 > 0) {
            int j = num % 10;
        }

        return sb.toString();
    }

    public String toStr(int i) {
        return "";
    }
}
