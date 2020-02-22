package com.za.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * 输入: [3,2,3]
 * 输出: [3]
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, count1 = 0;
        int num2 = 0, count2 = 0;
        for (int n : nums) {
            if (count1 == 0 && num2 != n) {
                num1 = n;
                count1 = 1;
            } else if (count2 == 0 && num1 != n) {
                num2 = n;
                count2 = 1;
            } else if (num1 == n) {
                count1++;
            } else if (num2 == n) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        for (int n : nums) {
            if (num1 == n) {
                count1++;
            } else if (num2 == n) {
                count2++;
            }
        }
        List<Integer> leftNums = new ArrayList<>(2);
        if (count1 > nums.length / 3)
            leftNums.add(num1);
        if (count2 > nums.length / 3)
            leftNums.add(num2);
        return leftNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 2, 1, 1, 3};
        LeetCode229 l229 = new LeetCode229();
        System.out.println(l229.majorityElement(nums));
    }
}
