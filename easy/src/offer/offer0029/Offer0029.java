package offer.offer0029;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * @author sxx_27
 * @create 2022-04-30 19:00
 */
public class Offer0029 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(new Solution().spiralOrder(matrix)));
    }
}

class Solution {
    public int[] spiralOrder0(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int temp = 0, r = 0, c = 0, count = 1, flag = 0;
        while (temp < row * col) {
            if (flag == 0) {
                if (c == col - count) {
                    flag = 1;
                    continue;
                }
                res[temp++] = matrix[r][c++];
            } else if (flag == 1) {
                if (r == row - count) {
                    flag = 2;
                    continue;
                }
                res[temp++] = matrix[r++][c];
            } else if (flag == 2) {
                if (c == count - 1) {
                    flag = 3;
                    count++;
                    continue;
                }
                res[temp++] = matrix[r][c--];
            } else if (flag == 3) {
                if (r == count - 1) {
                    flag = 0;
                    continue;
                }
                res[temp++] = matrix[r--][c];
            }
        }

        return res;
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int row = matrix.length - 1, col = matrix[0].length - 1, r = 0, c = 0, index = 0;
        while (true) {
            for (int i = c; i <= col; i++) {
                res[index++] = matrix[r][i];
            }
            if (++r > row) {
                break;
            }
            for (int i = r; i <= row; i++) {
                res[index++] = matrix[i][col];
            }
            if (--col < c) {
                break;
            }
            for (int i = col; i >= c; i--) {
                res[index++] = matrix[row][i];
            }
            if (--row < r) {
                break;
            }
            for (int i = row; i >= r; i--) {
                res[index++] = matrix[i][c];
            }
            if (++c > col) {
                break;
            }
        }
        return res;
    }
}