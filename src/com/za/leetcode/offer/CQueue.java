package com.za.leetcode.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class CQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if(out.empty()){
            while (!in.empty()){
                out.push(in.pop());
            }
        }
        if(out.empty())
            return -1;
        return out.pop();
    }
}
