package test.test0878;

import sun.applet.Main;

/**
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。
 * 因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * https://leetcode.cn/problems/nth-magical-number/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0878
 * @create 2022-11-22-14:09
 */
public class Test0878 {
    public static void main(String[] args) {
        System.out.println(new Solution().nthMagicalNumber(4, 3, 2));
    }
}

class Solution {
    private static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b), r = n * l;
        long c = getMinM(a, b);
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long pre = mid / a + mid / b - mid / c;
            if (pre >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    private long getMinM(int a, int b) {
        return ((long) a * b) / getMaxM(Math.max(a, b), Math.min(a, b));
    }

    private long getMaxM(int a, int b) {
        return b != 0 ? getMaxM(b, a % b) : a;
    }
}