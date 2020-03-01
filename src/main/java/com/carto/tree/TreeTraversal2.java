package com.carto.tree;

import com.carto.leetcode.util.TreeNode;

import java.util.*;

public class TreeTraversal2 {


    private void preOrder(TreeNode root) {

    }

    private List<Integer> midOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>(); // 先进先出不符合啊
        queue.add(root);
        TreeNode next = root.left; // 这里也不应该先赋值，因为有空指针的问题
        // 命名明显curr更好

        while (!queue.isEmpty() || next != null) {
            while (next != null) {
                queue.add(next);
                next = root.left;
            }

            TreeNode temp = queue.poll();
            result.add(temp.val);
            next = temp.right;
        }

        return result;
    }

    // 非递归先序遍历
    public static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " "); // 主要这个位置不一样
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    // 非递归中序遍历
    public static void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }
}
