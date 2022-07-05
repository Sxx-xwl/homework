package top.top062;

/**
 * 一个机器人位于一个 m x n网格的左上角
 * （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * @Classname Top062
 * @Version 1.0.0
 * @Date 2022/7/5 14:10
 * @Created by sxx_xwl
 */
public class Top062 {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] res = new int[m][n];
        for (int i = 1; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            int j = 0;
            while (++j < n) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}