package com.za.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead, tmpNode;
        newHead = tmpNode = new ListNode(0);
        int up = 0;//满10进1
        while (l1 != null && l2 != null) {
            tmpNode.next = new ListNode((l1.val + l2.val + up) % 10);
            up = (l1.val + l2.val + up) / 10;
            tmpNode = tmpNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null)
            while (l1 != null) {
                tmpNode.next = new ListNode((l1.val + up) % 10);
                up = (l1.val + up) / 10;
                tmpNode = tmpNode.next;
                l1 = l1.next;
            }
        else if (l2 != null)
            while (l2 != null) {
                tmpNode.next = new ListNode((l2.val + up) % 10);
                up = (l2.val + up) / 10;
                tmpNode = tmpNode.next;
                l2 = l2.next;
            }
        if (up > 0)
            tmpNode.next = new ListNode(up);
        return newHead.next;
    }
}

