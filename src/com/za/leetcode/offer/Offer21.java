package com.za.leetcode.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0 && nums[end] % 2 == 1) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            } else if (nums[start] % 2 == 0) {
                end--;
            } else if (nums[end] % 2 == 1) {
                start++;
            } else {
                end--;
                start++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Offer21 o21 = new Offer21();
        int[] nums = new int[]{1, 3, 2, 5, 4, 7, 6};
        nums = o21.exchange(nums);
        System.out.println(nums);
    }
}
