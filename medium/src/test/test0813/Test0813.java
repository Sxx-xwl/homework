package test.test0813;

/**
 * 给定数组 nums 和一个整数 k 。
 * 我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。
 * 分数 由每个子数组内的平均值的总和构成。
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 * https://leetcode.cn/problems/largest-sum-of-averages/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0813
 * @create 2022-11-28-16:28
 */
public class Test0813 {
    public static void main(String[] args) {

    }
}

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}