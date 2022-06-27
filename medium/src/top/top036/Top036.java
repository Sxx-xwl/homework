package top.top036;

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 *
 * @Classname Top036
 * @Version 1.0.0
 * @Date 2022/6/27 12:42
 * @Created by sxx_xwl
 */
public class Top036 {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Solution().isValidSudoku(board));
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean sudoku = sudoku(board);
        boolean b = sudoku2(board);
        return sudoku && b;
    }

    private boolean sudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                row[i][index]++;
                col[index][j]++;
                if (row[i][index] > 1 || col[index][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean sudoku2(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[((i / 3) * 3 + j / 3)][(i % 3) * 3 + j % 3] != '.' && !set.add(board[((i / 3) * 3 + j / 3)][(i % 3) * 3 + j % 3])) {
                    return false;
                }
            }
            set = new HashSet<>();
        }
        return true;
    }
}