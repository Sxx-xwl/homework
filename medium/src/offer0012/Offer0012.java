package offer0012;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。
 * 如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * @author sxx_27
 * @create 2022-05-12 14:28
 */
public class Offer0012 {

    public static void main(String[] args) {

    }
}

class Solution {
    public boolean exist(char[][] board, String word) {

        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, w, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, char[] w, int index, int row, int clo) {

        if (row >= board.length || row < 0 || clo < 0 || clo >= board[0].length || board[row][clo] != w[index]) {
            return false;
        }
        if (index == w.length - 1) {
            return true;
        }
        board[row][clo] = '\0';
        boolean res = isExist(board, w, index + 1, row + 1, clo) || isExist(board, w, index + 1, row, clo + 1)
                || isExist(board, w, index + 1, row - 1, clo) || isExist(board, w, index + 1, row, clo - 1);
        board[row][clo] = w[index];
        return res;
    }
}