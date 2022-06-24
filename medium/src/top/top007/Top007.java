package top.top007;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @Classname Top007
 * @Version 1.0.0
 * @Date 2022/6/24 9:52
 * @Created by sxx_xwl
 */
public class Top007 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
    }
}

class Solution {
    public int reverse(int x) {
        long res = 0;
        boolean flag;
        while (x != 0) {
            res = x % 10 + res * 10;
            x /= 10;
        }
        if (res - 2147483647 > 0) {
            return 0;
        } else if (res - (-2147483648) < 0) {
            return 0;
        } else {
            return (int) res;
        }
    }
}