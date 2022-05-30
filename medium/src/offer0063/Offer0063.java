package offer0063;

/**假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * @author sxx_27
 * @create 2022-05-30 13:42
 */
public class Offer0063 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max += (prices[i+1] - prices[i]);
            if (max < 0) max = 0;
            res = Math.max(res, max);
        }
        return res;
    }

    public int maxProfit1(int[] prices) {
        int cost = Integer.MAX_VALUE, res = 0;
        for (int price : prices) {
            cost = Math.min(price, cost);
            res = Math.max(res, price - cost);
        }
        return res;
    }
}