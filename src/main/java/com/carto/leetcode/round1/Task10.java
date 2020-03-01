package com.carto.leetcode.round1;

public class Task10 {
    public boolean isMatch(String s, String p) {

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (j >= p.length()) {
                return false;
            }
            if (isChEqual(s.charAt(i), p.charAt(j))) {
                i++;
                j++;
            } else if (p.charAt(j) == '*' && j - 1 >= 0 && isChEqual(s.charAt(i), p.charAt(j - 1))) {
                i++;
            } else {
                return false;
            }
        }


        return true;
    }

    private boolean isChEqual(Character a, Character b) {
        return a == b || b == '.';
    }
}
