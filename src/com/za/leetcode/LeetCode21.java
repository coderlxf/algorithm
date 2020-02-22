package com.za.leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                tmp.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null)
            tmp.next = l1;
        if (l2 != null)
            tmp.next = l2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(13);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        l2.next.next.next.next = new ListNode(7);
        l2.next.next.next.next.next = new ListNode(11);
        LeetCode21 l21 = new LeetCode21();
        ListNode l3 = l21.mergeTwoLists(l1, l2);
    }
}
