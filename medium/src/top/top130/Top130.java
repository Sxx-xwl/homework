package top.top130;

import java.util.Arrays;

/**
 * 给你一个 m x n 的矩阵 board ，
 * 由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
 * 并将这些区域里所有的 'O' 用 'X' 填充
 *
 * @Classname Top130
 * @Version 1.0.0
 * @Date 2022/7/11 20:48
 * @Created by sxx_xwl
 */
public class Top130 {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board1 = {{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        char[][] board2 = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
        char[][] board3 = {
        {'X','O','X','O','X','O','O','O','X','O'},
        {'X','O','O','X','X','X','O','O','O','X'},
        {'O','O','O','O','O','O','O','O','X','X'},
        {'O','O','O','O','O','O','X','O','O','X'},
        {'O','O','X','X','O','X','X','O','O','O'},
        {'X','O','O','X','X','X','O','X','X','O'},
        {'X','O','X','O','O','X','X','O','X','O'},
        {'X','X','O','X','X','O','X','O','O','X'},
        {'O','O','O','O','X','O','X','O','X','O'},
        {'X','X','O','X','X','X','X','O','O','O'}};
        for (int i = 0; i < board3.length; i++) {
            for (int j = 0; j < board3[i].length; j++) {
                System.out.print(board3[i][j]);
            }
            System.out.println();
        }
        System.out.println("*****************");
        new Solution().solve(board3);
        for (int i = 0; i < board3.length; i++) {
            for (int j = 0; j < board3[i].length; j++) {
                System.out.print(board3[i][j]);
            }
            System.out.println();
        }
    }
}

class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'S';
                if (i != 0 && i != board[0].length - 1) {
                    search(board, 1, i);
                }
            }
            if (board[board.length - 1][i] == 'O') {
                board[board.length - 1][i] = 'S';
                if (i != 0 && i != board[0].length - 1) {
                    search(board,board.length-2,i);
                }
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'S';
                search(board, i, 1);
            }
            if (board[i][board[0].length - 1] == 'O') {
                board[i][board[0].length - 1] = 'S';
                search(board, i, board[0].length - 2);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] == 'S' ? 'O' : 'X';
            }
        }
    }

    private void search(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'S') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'S';
            search(board, i - 1, j);
            search(board, i + 1, j);
            search(board, i, j - 1);
            search(board, i, j + 1);
        }
    }
}