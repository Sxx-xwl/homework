package test.test0805;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定你一个整数数组 nums
 * 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，
 * 使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
 * 如果可以完成则返回true ， 否则返回 false  。
 * 注意：对于数组 arr ,  average(arr) 是 arr 的所有元素的和除以 arr 长度。
 * https://leetcode.cn/problems/split-array-with-same-average/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0805
 * @create 2022-11-14-18:20
 */
public class Test0805 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.println(new Solution().splitArraySameAverage(nums));
    }
}

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int len = nums.length, left = len / 2, right = len - left;
        if (len == 1) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < len; i++) {
            nums[i] = len * nums[i] - sum;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < (1 << left); i++) {
            int leftSum = 0;
            for (int j = 0; j < left; j++) {
                if ((i & (1 << j)) != 0) {
                    leftSum += nums[j];
                }
            }
            if (0 == leftSum) return true;
            set.add(leftSum);
        }
        int rsum = 0;
        for (int i = left; i < len; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << right); i++) {
            int rightSum = 0;
            for (int j = left; j < len; j++) {
                if ((i & (1 << (j - left))) != 0) {
                    rightSum += nums[j];
                }
            }
            if (0 == rightSum) return true;
            if (rsum != rightSum && set.contains(-rightSum)) return true;
        }
        return false;
    }
}