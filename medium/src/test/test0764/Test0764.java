package test.test0764;

import java.util.Arrays;

/**
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，
 * 其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。
 * 如果未找到加号标志，则返回 0 。
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，
 * 以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * https://leetcode.cn/problems/largest-plus-sign/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0764
 * @create 2022-11-09-10:25
 */
public class Test0764 {
    public static void main(String[] args) {
        int[][] mines = new int[][]{{0, 0}, {0, 1}, {1, 0}};
        System.out.println(new Solution().orderOfLargestPlusSign(2, mines));
    }
}

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n == 1) {
            return mines[0][0];
        }
        int[][] temp = new int[n][n];
        for (int[] arr : temp) {
            Arrays.fill(arr, 1);
        }
        for (int[] a : mines) {
            temp[a[0]][a[1]] = 0;
        }
        int[][] up = new int[n][n], down = new int[n][n],
                left = new int[n][n], right = new int[n][n], res = new int[n][n];
        for (int[] arr : res) {
            Arrays.fill(arr, 5001);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    left[i][j] = temp[i][j];
                    right[i][n - j - 1] = temp[i][n - j - 1];
                    up[j][i] = temp[j][i];
                    down[n - j - 1][i] = temp[n - j - 1][i];
                } else {
                    left[i][j] = temp[i][j] == 1 && j != 0 ? left[i][j - 1] + 1 : 0;
                    right[i][n - j - 1] = temp[i][n - j - 1] == 1 && j != 0 ? right[i][n - j] + 1 : 0;
                    up[j][i] = temp[j][i] == 1 && j != 0 ? up[j - 1][i] + 1 : 0;
                    down[n - j - 1][i] = temp[n - j - 1][i] == 1 && j != 0 ? down[n - j][i] + 1 : 0;
                }

                res[i][j] = Math.min(res[i][j], left[i][j]);
                res[i][n - j - 1] = Math.min(res[i][n - j - 1], right[i][n - j - 1]);
                res[j][i] = Math.min(res[j][i], up[j][i]);
                res[n - j - 1][i] = Math.min(res[n - j - 1][i], down[n - j - 1][i]);
            }
        }
        int max = 0;
        for (int[] arr : res) {
            for (int num : arr) {
                max = Math.max(num, max);
            }
        }
        return max;
    }
}