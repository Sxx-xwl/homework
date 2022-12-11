package test.test0064;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0064
 * @create 2022-12-11-12:14
 */
public class Test0064 {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i >= 1 && j >= 1) {
                    res[i][j] = Math.min(res[i][j - 1], res[i - 1][j]) + grid[i][j];
                } else if (i < 1 && j >= 1) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                } else if (i >= 1 && j < 1) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                } else {
                    res[i][j] = grid[i][j];
                }
            }
        }
        return res[row - 1][col - 1];
    }
}