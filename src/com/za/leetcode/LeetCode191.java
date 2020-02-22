package com.za.leetcode;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 输入：00000000000000000000000010000000
 * 输出：1
 */
public class LeetCode191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 512;
        LeetCode191 l191 = new LeetCode191();
        System.out.println(num+"的二进制表示包含"+l191.hammingWeight(num)+"个数字1");
    }
}
