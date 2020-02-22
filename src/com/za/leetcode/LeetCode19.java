package com.za.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if ((n == 0 && fast == null) || (n > 0)) {
            ListNode tmp = head.next;
            head = null;
            return tmp;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next.val = slow.val;
        slow.next = slow.next.next;
        return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode fast = dummy;
//        ListNode slow = dummy;
//        while (n + 1 > 0) {
//            fast = fast.next;
//            n--;
//        }
//        while (fast != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return dummy.next;
    }
}
