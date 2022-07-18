package top.top162;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，
 * 返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * @Classname Top162
 * @Version 1.0.0
 * @Date 2022/7/18 13:15
 * @Created by sxx_xwl
 */
public class Top162 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2, 1};
        System.out.println(new Solution().findPeakElement(nums));
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}