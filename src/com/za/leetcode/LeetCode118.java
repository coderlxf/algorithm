package com.za.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * .[
 * ......[1],
 * .....[1,1],
 * ....[1,2,1],
 * ...[1,3,3,1],
 * ..[1,4,6,4,1]
 * .]
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> nums = new ArrayList<>();
        if(numRows==0)
            return nums;
        List<Integer> rowsLast = null;
        List<Integer> rows = new ArrayList<>();
        rows.add(1);
        nums.add(rows);
        for (int i = 1; i < numRows; i++) {
            rows = new ArrayList<>();
            rowsLast = nums.get(i - 1);
            rows.add(1);       
            for (int j = 1; j < i; j++) {
                rows.add(rowsLast.get(j - 1) + rowsLast.get(j));
            }
            rows.add(1);
            nums.add(rows);
        }
        return nums;
    }

    public static void main(String[] args) {
        int numRows = 4;
        LeetCode118 leetCode118 = new LeetCode118();
        List<List<Integer>> nums = leetCode118.generate(4);
        System.out.println(nums);
    }
}
