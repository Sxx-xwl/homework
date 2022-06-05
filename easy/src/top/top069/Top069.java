package top.top069;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @author sxx_27
 * @create 2022-06-05 21:59
 */
public class Top069 {
    public static void main(String[] args) {
//        System.out.println(new Solution().mySqrt(214));
        System.out.println(new Solution().mySqrt(8));
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int r = x, l = 1;
        int re = 0;
        while (l <= r) {
            int mid = (l + (r - l) / 2);
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                re = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return re;
    }
}