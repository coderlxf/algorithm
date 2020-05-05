package com.za.leetcode.offer;

import com.za.leetcode.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (nodeCompare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean nodeCompare(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return nodeCompare(A.left, B.left) && nodeCompare(A.right, B.right);
    }
}
