package com.za.leetcode.offer;

import com.za.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Offer3 {

    public List<Integer> reverseList(ListNode listNode) {
        if (listNode == null)
            return null;
        List<Integer> result = new ArrayList<>();
        Stack<Integer> tmpStack = new Stack<>();
        while (listNode != null) {
            tmpStack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!tmpStack.empty()) {
            result.add(tmpStack.pop());
        }
        return result;
    }
}
