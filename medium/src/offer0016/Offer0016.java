package offer0016;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * @author sxx_27
 * @create 2022-05-14 14:48
 */
public class Offer0016 {
    public static void main(String[] args) {

        System.out.println(new Solution().myPow(2, -2147483648));
        System.out.println(new Solution().myPow1(2, -2147483648));
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        long b = n;
        x = n < 0 ? 1 / x : x;
        b = n < 0 ? -b : b;
        double res = 1.0;
        while (b > 0) {
            long flag = b % 2;
            if (flag != 0) {
                res *= x;
            }
            x *= x;
            b /= 2;
        }
        return res;
    }

    public double myPow1(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

}