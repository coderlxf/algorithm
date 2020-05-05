package com.za.leetcode.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class Offer13 {
    public int movingCount(int m, int n, int k) {
        int arr[][] = new int[m][n];
        return addCount(arr, 0, 0, m, n, k);
    }

    private int addCount(int[][] arr, int i, int j, int m, int n, int k) {
        if (i >= 0 && i < m && j >= 0 && j < n && getSumFromNum(i) + getSumFromNum(j) <= k && arr[i][j] != -1) {
            arr[i][j] = -1;
            return 1 + addCount(arr, i - 1, j, m, n, k)
                    + addCount(arr, i + 1, j, m, n, k)
                    + addCount(arr, i, j - 1, m, n, k)
                    + addCount(arr, i, j + 1, m, n, k);
        }
        return 0;
    }

    private int getSumFromNum(int n) {
        if (n < 10) return n;
        else if (n < 100) return n / 10 + n % 10;
        else if (n == 100) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 1;
        int k = 9;
        Offer13 o13 = new Offer13();
        int res = o13.movingCount(m, n, k);
        System.out.println(res);
    }

}
