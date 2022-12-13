package test.test0260;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * https://leetcode.cn/problems/single-number-iii/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0260
 * @create 2022-12-13-19:51
 */
public class Test0260 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        long l = 0, r = 0;
        for (int a : nums) {
            l ^= a;
        }
        r = l;
        long temp = r;
        int index = 0;
        while ((temp & 1) == 0) {
            index++;
            temp = temp >> 1;
        }
        for (int a : nums) {
            if (((a >> index) & 1) != 0) {
                l ^= a;
            }
        }
        r ^= l;
        return new int[]{(int) r,(int)l};
    }
}