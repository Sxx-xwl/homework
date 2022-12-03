package test.test0213;

import sun.nio.cs.ext.MacHebrew;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * https://leetcode.cn/problems/house-robber-ii/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0213
 * @create 2022-12-03-11:37
 */
public class Test0213 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length, res = 0;
        if (len <= 3) {
            for (int a : nums) {
                res = Math.max(a, res);
            }
            return res;
        }
        //抢第一家
        int a1 = nums[0], a2 = nums[1], a3 = nums[2] + nums[0];
        //不抢第一家
        int b1 = 0, b2 = nums[1], b3 = nums[2];
        for (int i = 3; i < len - 1; i++) {
            int temp = Math.max((Math.max(a1, a2) + nums[i]), a3);
            a1 = a2;
            a2 = a3;
            a3 = temp;
        }
        for (int i = 3; i < len; i++) {
            int temp = Math.max((Math.max(b1, b2) + nums[i]), b3);
            b1 = b2;
            b2 = b3;
            b3 = temp;
        }
        return Math.max(a3, b3);
    }
}