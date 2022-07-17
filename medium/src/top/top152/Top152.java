package top.top152;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，
 * 请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 测试用例的答案是一个32-位 整数。
 * 子数组 是数组的连续子序列。
 *
 * @Classname Top152
 * @Version 1.0.0
 * @Date 2022/7/17 14:35
 * @Created by sxx_xwl
 */
public class Top152 {
    public static void main(String[] args) {
        int[] nums = {-2, 4, -3};
        System.out.println(new Solution().maxProduct(nums));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length - 1;

        int[] copy = new int[len + 1];
        //最大正整数
        int max1 = nums[0];
        //最大负整数
        int max2 = nums[0];
        int res = nums[0];
        for (int i = 1; i <= len; i++) {
            int a = max1, b =max2;
            max1 = Math.max(a * nums[i], Math.max(nums[i], b * nums[i]));
            max2 = Math.min(b * nums[i], Math.min(nums[i], a * nums[i]));
            res = Math.max(max1,res);
        }
        return res;
    }
}