package com.za.leetcode;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        int i = 0, j = 0;
        int mid = count / 2;
        while (i + j < mid - 1 && i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] < nums2[j])
                i++;
        }
        if (i + j >= mid - 1 && i < nums1.length && j < nums2.length) {
            if (count % 2 != 0) {
                return i > j ? nums1[i] : nums2[j];
            }
            return (nums1[i] + nums2[j]) / 2.0;
        } else if (j == nums2.length) {
            while (i < mid && i < nums1.length) {
                i++;
            }
            if (count % 2 != 0) {
                return nums1[i];
            }
            return (nums1[i - 1] + nums1[i]) / 2.0;
        } else {
            while (j < mid && j < nums2.length) {
                j++;
            }
            if (count % 2 != 0) {
                return nums2[j];
            }
            return (nums2[j - 1] + nums2[j]) / 2.0;
        }
    }

    public static void main(String[] args) {
        LeetCode4 l4 = new LeetCode4();
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        System.out.println(l4.findMedianSortedArrays(num1, num2));
    }
}
