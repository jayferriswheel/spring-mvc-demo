package com.carto.leetcode.round1;


/**
 * [2,3,1,1,4]
 * <p>
 * [3,2,1,0,4]
 */
public class Task55 {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
