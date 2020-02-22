package com.za.leetcode.offer;

import com.za.leetcode.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int size = s.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = s.pop();
        }
        return nums;
    }
}
