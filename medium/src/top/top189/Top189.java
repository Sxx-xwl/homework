package top.top189;

import java.util.Arrays;

/**
 * 给你一个数组，
 * 将数组中的元素向右轮转 k 个位置，
 * 其中 k 是非负数。
 *
 * @Classname Top189
 * @Version 1.0.0
 * @Date 2022/7/19 14:59
 * @Created by sxx_xwl
 */
public class Top189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}