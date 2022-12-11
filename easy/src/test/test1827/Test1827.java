package test.test1827;

/**
 * 给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
 * 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
 * 请你返回使 nums 严格递增 的 最少 操作次数。
 * 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。
 * 一个长度为 1 的数组是严格递增的一种特殊情况。
 * https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1827
 * @create 2022-12-11-11:55
 */
public class Test1827 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minOperations(int[] nums) {
        int maxV = nums[0], res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxV) {
                maxV = nums[i];
            } else {
                res += maxV - nums[i] + 1;
                maxV += 1;
            }
        }
        return res;
    }
}