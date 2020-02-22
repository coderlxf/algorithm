package com.za.leetcode;

import com.za.utils.DataUtil;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep != null && twoStep.next != null) {
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
        }
        return oneStep;
    }

    public static void main(String[] args) {
        ListNode head = DataUtil.createOddNodesLinkedList();
        LeetCode876 l876 = new LeetCode876();
        ListNode mid = l876.middleNode(head);
        System.out.println(mid.val);
        head = DataUtil.createEvenNodesLinkedList();
        mid = l876.middleNode(head);
        System.out.println(mid.val);
        head = new ListNode(1);
        mid = l876.middleNode(head);
        System.out.println(mid.val);
        head = new ListNode(1);
        head.next = new ListNode(2);
        mid = l876.middleNode(head);
        System.out.println(mid.val);
    }
}
