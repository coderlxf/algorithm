package com.za.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 * <p>
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class LeetCode42 {
    //按列求，当前列两侧的最大列高度中较小的与当前列比较，大于当前列，作差则为蓄水高度
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            int hMaxLeft = 0;
            int hMaxRight = 0;
            for (int j = 0; j < i; j++) {
                if (hMaxLeft < height[j]) hMaxLeft = height[j];
            }
            for (int j = i + 1; j < height.length; j++) {
                if (hMaxRight < height[j]) hMaxRight = height[j];
            }
            int hTmp = Math.min(hMaxLeft, hMaxRight);
            if (hTmp > h)
                sum += hTmp - h;
        }
        return sum;
    }

    //用数组记录当前列的左侧高度最大和右侧高度最大
    public int trap2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int tmp = Math.min(max_left[i], max_right[i]);
            if (tmp > height[i]) sum += (tmp - height[i]);
        }
        return sum;
    }

    //双指针
    public int trap3(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 0; i < height.length; i++) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                if (max_left > height[i])
                    sum += max_left - height[i];
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                if (max_right > height[i])
                    sum += max_right - height[i];
                right--;
            }
        }
        return sum;
    }
}