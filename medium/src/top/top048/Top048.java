package top.top048;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。
 * 请你将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要使用另一个矩阵来旋转图像。
 *
 * @Classname Top048
 * @Version 1.0.0
 * @Date 2022/6/30 13:09
 * @Created by sxx_xwl
 */
public class Top048 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                int a = i, b = j;
                int times = 4;
                int temp1 = matrix[matrix.length - 1 - j][i];
                while (times-- >= 1) {
                    int temp2 = matrix[a][b];
                    matrix[a][b] = temp1;
                    int t = a;
                    a = b;
                    b = matrix.length - 1 - t;
                    temp1 = temp2;
                }
            }
        }
    }
}