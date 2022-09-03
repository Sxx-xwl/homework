package top.top238;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，返回 数组answer，
 * 其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top238
 * @create 2022-09-03-22:07
 */
public class Top238 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ints = new Solution().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, flag = 0, ls = 1, rs = 1;
        int[] res = new int[len];
        int add = len % 2;
        for (int i = 0; i < len; i++) {
            if (flag == 2) return new int[len];
            flag += nums[i] == 0 ? 1 : 0;
            if (i < (len / 2 + add)) {
                res[len - i - 1] = 1;
                res[i] = 1;
            }
            res[len - i - 1] *= rs;
            res[i] *= ls;

            rs *= nums[len - 1 - i];
            ls *= nums[i];
        }
        return res;
    }

    //除法版
    public int[] productExceptSelf0(int[] nums) {
        int sum = 1, flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                flag++;
            } else {
                sum *= nums[i];
            }
        }
        if (flag > 1) {
            return new int[nums.length];
        } else if (flag == 1) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] == 0 ? sum : 0;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sum / nums[i];
            }
        }
        return nums;
    }
}