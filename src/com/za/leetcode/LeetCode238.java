package com.za.leetcode;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 禁止使用除法
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int sums[] = new int[nums.length];
        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = mul;
            mul *= nums[i];
        }
        mul = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            sums[j] *= mul;
            mul *=nums[j];
        }
        return sums;
    }
}
