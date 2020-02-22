package com.za.utils;

import com.za.leetcode.ListNode;
import com.za.leetcode.TreeNode;

import java.util.List;

public class DataUtil {

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode tl = root.left;
        tl.left = new TreeNode(4);
        tl.right = new TreeNode(5);
        TreeNode tr = root.right;
        tr.left = new TreeNode(6);
        tr.right = new TreeNode(7);
        return root;
    }

    public static ListNode createOddNodesLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public static ListNode createEvenNodesLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        return head;
    }

    public static void listOfLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
