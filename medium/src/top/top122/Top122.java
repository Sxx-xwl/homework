package top.top122;

/**
 * 给你一个整数数组 prices ，
 * 其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。
 * 你在任何时候最多只能持有 一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 *
 * @Classname Top122
 * @Version 1.0.0
 * @Date 2022/7/10 14:48
 * @Created by sxx_xwl
 */
public class Top122 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}