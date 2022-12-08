package test.test1775;

/**
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1775
 * @create 2022-12-07-11:38
 */
public class Test1775 {
    public static void main(String[] args) {
        System.out.println(new Solution().
                minOperations(new int[]{5, 2, 1, 5, 2, 2, 2, 2, 4, 3, 3, 5}, new int[]{1, 4, 5, 5, 6, 3, 1, 3, 3}));
    }
}

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (6 * n < m || 6 * m < n) {
            return -1;
        }
        int diff = 0;
        for (int i : nums1) diff += i;
        for (int i : nums2) diff -= i;
        if (diff == 0) return 0;

        if (diff > 0) {
            return help(nums2, nums1, diff);
        } else {
            return help(nums1, nums2, -diff);
        }
    }

    private int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[6];
        for (int x : h1) h[6 - x]++;
        for (int x : h2) h[x - 1]++;
        int res = 0;
        for (int i = 5; i >= 0; i--) {
            if (h[i] * i > diff) {
                res += diff % i == 0 ? diff / i : diff / i + 1;
                return res;
            } else {
                diff -= h[i] * i;
                res += h[i];
            }
        }
        return res;
    }
}