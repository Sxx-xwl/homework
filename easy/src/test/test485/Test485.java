package test.test485;

/**
 * 给定一个二进制数组 nums ，
 * 计算其中最大连续 1 的个数。
 * https://leetcode.cn/problems/max-consecutive-ones/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test485
 * @create 2022-11-24-13:20
 */
public class Test485 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0;
        for (int a : nums) {
            if (a == 1) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 0;
            }
        }
        return Math.max(res,cur);
    }
}