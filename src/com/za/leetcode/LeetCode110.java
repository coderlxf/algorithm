package com.za.leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * （一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。）
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return getTreeHeight(root) != -1;
    }

    private int getTreeHeight(TreeNode node) {
        if (node == null) return 0;
        int left = getTreeHeight(node.left);
        if (left == -1) return -1;
        int right = getTreeHeight(node.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
