package offer.offer0060;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，
 * 所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，
 * 其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * @author sxx_27
 * @create 2022-05-28 11:21
 */
public class Offer0060 {


}

class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[k + j] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}