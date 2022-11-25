package test.test0795;

/**
 * 给你一个整数数组 nums 和两个整数：left 及 right 。
 * 找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，
 * 并返回满足条件的子数组的个数。
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0795
 * @create 2022-11-24-13:25
 */
public class Test0795 {
    public static void main(String[] args) {
        int[] nums = new int[]{16, 69, 88, 85, 79, 87, 37, 33, 39, 34};
        System.out.println(new Solution().numSubarrayBoundedMax(nums, 55, 57));
    }
}

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, pre = Integer.MAX_VALUE, rm = -1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp >= left && temp <= right) {
                if (pre == Integer.MAX_VALUE) pre = i;
                rm = i;
            } else if (temp < left) {
                if (pre == Integer.MAX_VALUE) pre = i;
            } else {
                pre = Integer.MAX_VALUE;
                rm = -1;
            }
            if (rm != -1) res += (rm - pre + 1);
        }
        return res;
    }
}