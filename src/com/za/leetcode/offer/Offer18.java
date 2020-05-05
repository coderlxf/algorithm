package com.za.leetcode.offer;

import com.za.leetcode.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        newHead.next = head;
        while (p.next != null) {
            if(p.next.val == val){
                break;
            }
            p = p.next;
        }
        if(p.next == null && p.val == val)
            p = null;
        else
            p.next = p.next.next;
        return newHead.next;
    }
}
