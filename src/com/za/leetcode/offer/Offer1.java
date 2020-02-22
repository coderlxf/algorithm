package com.za.leetcode.offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Offer1 {

    public boolean Find(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = 0, j = array[0].length - 1;
        while (i <= array.length - 1 && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int array[][] = new int[][]{{1, 2, 7}, {3, 4, 8}, {5, 6, 9}};
        Offer1 offer1 = new Offer1();
        boolean isContained = offer1.Find(array, 3);
        System.out.println("array contains:" + isContained);
    }
}
