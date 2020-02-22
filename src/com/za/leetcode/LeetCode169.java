package com.za.leetcode;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 输入: [3,2,3]
 * 输出: 3
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for (int n : nums) {
            if (count == 0)
                num = n;
            count += (num == n) ? 1 : -1;
        }
        return num;
    }
}
