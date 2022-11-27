package test.test1752;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 * 源数组中可能存在 重复项 。
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，
 * 当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 * https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1752
 * @create 2022-11-27-10:54
 */
public class Test1752 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean check(int[] nums) {
        int len = nums.length, index = 1;
        if (len < 3) return true;
        boolean flag = false;
        while (index <= len) {
            if (nums[index % len] < nums[index - 1]) {
                if (flag) return false;
                flag = true;
            }
            index++;
        }
        return true;
    }
}