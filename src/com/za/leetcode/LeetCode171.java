package com.za.leetcode;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例:
 * 输入: "A"   输入: "AB"   输入: "ZY"
 * 输出: 1     输出: 28     输出: 701
 */
public class LeetCode171 {
    public int titleToNumber(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            total = total * 26 + (c - 65 + 1);
        }
        return total;
    }
    public static void main(String[] args) {
        LeetCode171 l171 = new LeetCode171();
        String s = "AZY";
        System.out.println(s + "表示的Excel列序号为：" + l171.titleToNumber(s));
    }
}
