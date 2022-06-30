package top.top029;

/**
 * 给定两个整数，被除数dividend和除数divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，
 * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 商×除数+余数=被除数。
 *
 * @Classname Top029
 * @Version 1.0.0
 * @Date 2022/6/29 16:22
 * @Created by sxx_xwl
 */
public class Top029 {
    public static void main(String[] args) {
        System.out.println(new Solution().divide(100, 2));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag;
        flag = (dividend ^ divisor) < 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                res += (1 << i);
                a -= b * (1L << i);
            }
        }
        return flag ? -res : res;
    }
}