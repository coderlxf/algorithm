package com.za.leetcode;

import com.za.utils.DataUtil;

import javax.xml.crypto.Data;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = DataUtil.createOddNodesLinkedList();
        LeetCode206 l206 = new LeetCode206();
        ListNode newHead = l206.reverseList2(head);
        DataUtil.listOfLinkedList(newHead);
    }
}
