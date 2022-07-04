package top.top050;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 * @Classname Top050
 * @Version 1.0.0
 * @Date 2022/7/1 10:51
 * @Created by sxx_xwl
 */
public class Top050 {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(8.84372, -5));
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        long m = n;
        if (n < 0) {
            x = 1 / x;
            m = -m;
        }
        double res = 1;
        double temp = x;
        while (m > 0) {
            if (m % 2 != 0) {
                res = temp * res;
            }
            temp *= temp;
            m = m / 2;
        }
        return res;
    }
}