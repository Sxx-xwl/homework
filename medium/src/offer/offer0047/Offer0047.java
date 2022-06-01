package offer.offer0047;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，
 * 每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，
 * 请计算你最多能拿到多少价值的礼物？
 *
 * @author sxx_27
 * @create 2022-05-24 13:16
 */
public class Offer0047 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
//        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(new Solution().maxValue0(grid));
        System.out.println(new Solution().maxValue(grid));

    }
}

class Solution {
    //原地改动
    public int maxValue(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int i, j = 0;
        for (i = 0; i < rLen; i++) {
            for (j = 0; j < cLen; j++) {
                if (i == 0 && j != 0) {
                    grid[0][j] += grid[0][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][0] += grid[i - 1][0];
                } else if (i != 0 && j != 0) {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[i - 1][j - 1];
    }

    //滚动数组
    public int maxValue0(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        int[][] dp = new int[2][cLen];
        int i, j = 0;
        for (i = 0; i < rLen; i++) {
            for (j = 0; j < cLen; j++) {
                if (i == 0 && j != 0) {
                    dp[i % 2][j] = dp[i % 2][j - 1] + grid[0][j];
                } else if (i != 0 && j == 0) {
                    dp[i % 2][0] = dp[(i + 1) % 2][0] + grid[i][0];
                } else if (i != 0 && j != 0) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j - 1], dp[(i + 1) % 2][j]) + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[(i + 1) % 2][j - 1];
    }

}