package test.test1822;

/**
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1822
 * @create 2022-10-27-11:24
 */
public class Test1822 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            res *= nums[i] < 0 ? -1 : 1;
        }
        return res;
    }
}