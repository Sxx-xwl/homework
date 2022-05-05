package test053;

/**
 * @author sxx_27
 * @create 2022-01-19 17:54
 */
/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。



示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

示例 2：

输入：nums = [1]
输出：1

示例 3：

输入：nums = [5,4,-1,7,8]
输出：2

 */
public class Test053 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int nums[] = new int[]{-2,4,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));

    }


}
/*
    // 暴力解法

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max ;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = nums[i];
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max , sum);
            }
            maxSum = Math.max(max, maxSum);
            sum = 0;
        }
        return maxSum;
    }
}
*/
/*
        //贪心算法
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }
}
