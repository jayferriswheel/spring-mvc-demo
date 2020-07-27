package com.carto.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjie263
 * @date 2020/6/4 10:43
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(tmp, result, nums, i + 1);
            tmp.remove(nums[i]);
        }
        return result;
    }

    private void backtrack(List<Integer> tmp, List<List<Integer>> result, int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[i]);
        backtrack(tmp, result, nums, i + 1);
    }
}
