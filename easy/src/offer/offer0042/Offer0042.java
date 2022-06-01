package offer.offer0042;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * @author sxx_27
 * @create 2022-05-04 16:28
 */
public class Offer0042 {

    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        return res;
    }
    public int leetcode(int[] nums){
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0]=nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max , dp[i]);
        }

        return max;
    }
}