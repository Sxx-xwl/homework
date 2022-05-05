package test121;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @author sxx_27
 * @create 2022-02-20 19:32
 */
public class Test121 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int i1 = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i1);
        int i2 = solution.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(i2);
        int i3 = solution.maxProfit(new int[]{1, 2});
        System.out.println(i3);

    }

}
class Solution {
    public int maxProfit0(int[] prices) {

        int min = prices[0];
        int maxRes = 0;
        for (int i = 1; i < prices.length; i++) {

            min = prices[i] < min ? prices[i] : min;
            maxRes = (prices[i] - min) > maxRes ? (prices[i] - min) : maxRes;
        }
        return maxRes;
    }

    public int maxProfit(int[] prices) {

        int flag = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[flag] <= 0)
            {
                flag = i;
            }else
            {
                max = prices[i] - prices[flag] > max ? prices[i] - prices[flag] : max;
            }
        }
        return max;
    }
}