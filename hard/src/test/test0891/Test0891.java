package test.test0891;

import java.util.Arrays;

/**
 * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
 * 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。
 * 由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
 * 子序列 定义为从一个数组里删除一些（或者不删除）元素，
 * 但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
 * https://leetcode.cn/problems/sum-of-subsequence-widths/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0891
 * @create 2022-11-18-13:37
 */
public class Test0891 {
    public static void main(String[] args) {

    }
}

class Solution {
    final static long MOD = (long) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        long minSum = 0, maxSum = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            minSum = (minSum * 2 + nums[i]) % MOD;
            maxSum = (maxSum * 2 + nums[len - i - 1]) % MOD;
        }
        return (int) ((maxSum + MOD - minSum) % MOD);
    }
}