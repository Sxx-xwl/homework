package top.top198;

/**
 * 你是一个专业的小偷，
 * 计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 *
 * @Classname Top198
 * @Version 1.0.0
 * @Date 2022/7/20 12:37
 * @Created by sxx_xwl
 */
public class Top198 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0], b = Math.max(a, nums[1]);
        int index = 2, res = 0;
        while (index < nums.length) {
            res = Math.max(b, a + nums[index]);
            a = b;
            b = res;
            index++;
        }
        return res;
    }
}