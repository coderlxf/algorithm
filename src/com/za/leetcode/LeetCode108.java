package com.za.leetcode;


/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 给定有序数组: [-10,-3,0,5,9]
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * .......0
 * ....../ \
 * ....-3   9
 * ..../   /
 * ..-10  5
 */
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return tree(nums, 0, nums.length - 1);
    }

    private TreeNode tree(int[] nums, int start, int end) {
        if (start > end) return null;
//        int mid = start + (end - start) / 2;
        int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = tree(nums, start, mid - 1);
        root.right = tree(nums, mid + 1, end);
        return root;
    }
}
