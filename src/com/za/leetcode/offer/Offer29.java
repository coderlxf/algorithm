package com.za.leetcode.offer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int x = 0;
        int l = 0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        int[] res = new int[(b+1)*(r+1)];
        while(true){
            // for(int i=l;i<=r;i++){
            //     res[x++] = matrix[t][i];
            // }
            // if(++t>b) break;
            //  for(int i=t;i<=b;i++){
            //     res[x++] = matrix[i][r];
            // }
            // if(--r<l) break;
            // for(int i=r;i>=l;i++){
            //     res[x++] = matrix[b][i];
            // }
            // if(--b<t) break;
            //  for(int i=b;i>=t;i++){
            //     res[x++] = matrix[i][l];
            // }
            // if(++l>r) break;
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}
