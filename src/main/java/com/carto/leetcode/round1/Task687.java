package com.carto.leetcode.round1;

import com.carto.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Task687 {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            max = Math.max(sum(node), max);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return max;
    }

    int sum(TreeNode node) {
        int res = 0;
        if (node.left != null && node.left.val == node.val) {
            res = res + 1 + sum(node.left);
        }
        if (node.right != null && node.right.val == node.val) {
            res = res + 1 + sum(node.right);
        }

        ans = Math.max(ans, res);

        return res;
    }
}
