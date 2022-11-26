package test.test0016;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * https://leetcode.cn/problems/3sum-closest/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0016
 * @create 2022-11-26-16:47
 */
public class Test0016 {
    public static void main(String[] args) {

    }
}

class Solution {
    private int res;

    public int threeSumClosest(int[] nums, int target) {
        int cur;
        res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            cur = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + cur;
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    res = sum - target < Math.abs(res - target) ? sum : res;
                    r--;
                } else {
                    res = target - sum < Math.abs(res - target) ? sum : res;
                    l++;
                }
            }
        }
        return res;
    }
}