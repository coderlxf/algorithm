package com.za.leetcode.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(select(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean select(char[][] board, int i, int j, String word, int depth) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(depth))
            return false;
        if (word.length() - 1 == depth) return true;
        char tmp = board[i][j];
        board[i][j] = '.';
        boolean res = select(board, i, j - 1, word, depth + 1)
                || select(board, i + 1, j, word, depth + 1)
                || select(board, i, j + 1, word, depth + 1)
                || select(board, i - 1, j, word, depth + 1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        Offer12 o12 = new Offer12();
        boolean exist = o12.exist(board, word);
        System.out.println(exist);
    }
}
