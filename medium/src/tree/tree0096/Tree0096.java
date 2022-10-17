package tree.tree0096;

/**
 * 给你一个整数 n ，
 * 求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className tree.tree0095.tree0096
 * @create 2022-10-17-15:37
 */
public class Tree0096 {
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}