package com.carto.leetcode.round1;

public class Task14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        return prefix(strs[0], strs, 1);
    }

    public String prefix(String str1, String[] strs, int index) {
        if (str1 == "" || index >= strs.length) return str1;
        return prefix(compare(str1, strs[index]), strs, index++);
    }

    public String compare(String str1, String str2) {
        int i = 0;
        int j = 0;
        String res = "";

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                res += str1.charAt(i);
                i++;
                j++;
            } else {
                break;
            }
        }

        return res;
    }
}
