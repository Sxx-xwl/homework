package top.top079;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。
 * 如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * @Classname Top079
 * @Version 1.0.0
 * @Date 2022/7/6 14:07
 * @Created by sxx_xwl
 */
public class Top079 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'},
                {'s', 'f', 'e', 's'},
                {'a', 'd', 'e', 'e'}};
        char[][] board0 = {{'c', 'a', 'a'},
                {'a', 'a', 'a'},
                {'b', 'c', 'd'}};
        System.out.println(new Solution().exist(board, "abceseeefs"));
    }
}

class Solution {
    boolean flag;
    boolean[][] booleans;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    booleans = new boolean[board.length][board[0].length];

                    if (search(board, word, i, j, 0)) {
                        return true;
                    }
//                    search(board, word, i, j, 0);
//                    if (flag) {
//                        return true;
//                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int len) {
        if (len == word.length() - 1) {
//            flag = true;
            return true;
        }
        booleans[i][j] = true;
        if ((i - 1 >= 0 && j >= 0) && board[i - 1][j] == word.charAt(len + 1) && !booleans[i - 1][j]) {
            flag = flag || search(board, word, i - 1, j, len + 1);
        }
        if ((i >= 0 && j - 1 >= 0) && board[i][j - 1] == word.charAt(len + 1) && !booleans[i][j - 1]) {
            flag = flag || search(board, word, i, j - 1, len + 1);
        }
        if ((i + 1 < board.length && j < board[i + 1].length) && board[i + 1][j] == word.charAt(len + 1) && !booleans[i + 1][j]) {
            flag = flag || search(board, word, i + 1, j, len + 1);
        }
        if ((i < board.length && j + 1 < board[i].length) && board[i][j + 1] == word.charAt(len + 1) && !booleans[i][j + 1]) {
            flag = flag || search(board, word, i, j + 1, len + 1);
        }
        booleans[i][j] = false;
        return flag;
    }
}