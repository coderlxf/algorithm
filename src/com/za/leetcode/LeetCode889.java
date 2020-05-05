package com.za.leetcode;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 */
public class LeetCode889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[0]);
        return root;
    }

    private TreeNode getTree(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        TreeNode root = new TreeNode(pre[0]);
        return root;
    }
}
