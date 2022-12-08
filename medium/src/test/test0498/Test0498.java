package test.test0498;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，
 * 请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * https://leetcode.cn/problems/diagonal-traverse/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0498
 * @create 2022-12-07-11:43
 */
public class Test0498 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(new int[][]{{1, 2}, {3, 4}})));
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int lenR = mat.length, lenC = mat[0].length;
        int[] res = new int[lenR * lenC];
        int row = 0, col = 0, sum = 0;
        for (int i = 0; i < lenR * lenC; i++) {
            res[i] = mat[row][col];
            if (sum % 2 == 0) {
                if (col == lenC - 1) {
                    row++;
                    sum++;
                } else if (row == 0) {
                    sum++;
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == lenR - 1) {
                    sum++;
                    col++;
                } else if (col == 0) {
                    sum++;
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}