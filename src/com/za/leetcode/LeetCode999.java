package com.za.leetcode;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
 * 直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
 * 另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 *  
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 */
public class LeetCode999 {
    public int numRookCaptures(char[][] board) {
        int rX = 0, rY = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    rX = i;
                    rY = j;
                    break;
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int total = 0;
        for (int i = 0; i < 4; i++) {
            int tmpX = rX;
            int tmpY = rY;
            while (true) {
                tmpX += dx[i];
                tmpY += dy[i];
                if (tmpX < 0 || tmpX == 8 || tmpY < 0 || tmpY == 8 || board[tmpX][tmpY] == 'B')
                    break;
                if (board[tmpX][tmpY] == 'p') {
                    total++;
                    break;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        LeetCode999 l999 = new LeetCode999();
        int total = l999.numRookCaptures(board);
        System.out.println(total);
    }
}
