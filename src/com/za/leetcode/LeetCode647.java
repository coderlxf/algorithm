package com.za.leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 */
public class LeetCode647 {
    private int aroundLength(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            count++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        if (s == null || "".equals(s)) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += aroundLength(s, i, i);
            count += aroundLength(s, i, i + 1);
        }
        return count;
    }
}
