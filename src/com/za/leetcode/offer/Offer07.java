package com.za.leetcode.offer;

import com.za.leetcode.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * -----3
 * ----/ \
 * ---9  20
 * -----/  \
 * ----15   7
 */
public class Offer07 {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTreeRoot(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode getTreeRoot(int[] preorder, int[] inorder, int start, int end) {
        if (preIndex == preorder.length || start > end) return null;
        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        for (int i = start; i < end + 1; i++) {
            if (rootVal == inorder[i]) {
                root.left = getTreeRoot(preorder, inorder, start, i - 1);
                root.right = getTreeRoot(preorder, inorder, i + 1, end);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Offer07 o7 = new Offer07();
        TreeNode root = o7.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
