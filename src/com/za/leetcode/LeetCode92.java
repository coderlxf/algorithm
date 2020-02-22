package com.za.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tail = null;
        ListNode con = null;
        ListNode pre = null;
        ListNode cur = head;
        int count = 1;
        while (cur != null && count <= n) {
            if (count == m) {
                con = pre;
                tail = cur;
            }
            if (count >= m) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
            count++;
        }
        tail.next = cur;
        if (con == null)
            head = pre;
        else
            con.next = pre;
        return head;
    }

    /**
     *
     * 交换链表两个节点
     *
     * pre->head->next->null
     * 过程：
     * head.next = next.next;
     * next.next = pre.next;
     * pre.next = next;
     * 结果：
     * pre->next->head->null
     *
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        LeetCode92 l92 = new LeetCode92();
        ListNode root = l92.reverseBetween2(head, 3, 6);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
