package top.top073;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，
 * 则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @Classname Top073
 * @Version 1.0.0
 * @Date 2022/7/5 14:31
 * @Created by sxx_xwl
 */
public class Top073 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] mat0 = {{0, 2, 3, 0}, {5, 1, 7, 8}, {1, 1, 1, 2}};
        new Solution()
                .setZeroes(mat0);
        for (int[] a : mat0) {
            System.out.println(Arrays.toString(a));
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flagrow = false;
        boolean flagclo = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i != 0 && j != 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    } else if (i == 0) {
                        if (j == 0) {
                            flagclo = true;
                        }
                        flagrow = true;
                    } else {
                        flagclo = true;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                int temp = 1;
                while (temp < matrix[i].length) {
                    matrix[i][temp++] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                int temp = 1;
                while (temp < matrix.length) {
                    matrix[temp++][i] = 0;
                }
            }
        }
        if (flagclo) {
            int temp = 0;
            while (temp < matrix.length) {
                matrix[temp++][0] = 0;
            }
        }
        if (flagrow) {
            int temp = 0;
            while (temp < matrix[0].length) {
                matrix[0][temp++] = 0;
            }
        }
    }
}