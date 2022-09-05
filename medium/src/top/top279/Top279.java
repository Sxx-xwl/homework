package top.top279;

import java.util.TreeMap;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className top.top279
 * @create 2022-09-05-23:28
 */
public class Top279 {
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(11));
    }
}

//动态规划
class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, nums[i - j * j]);
            }
            nums[i] = min + 1;
        }
        return nums[n];
    }
}

//数学方法
class Solution0 {
    public int numSquares(int n) {
        double b = Math.sqrt(n);
        if (b % 1 == 0) {
            return 1;
        }
        if (isFour(n)) {
            return 4;
        }
        if (isTwo(n)) {
            return 2;
        }
        return 3;
    }

    private boolean isFour(int n) {
        while (true) {
            for (int i = 0; i <= n / 8; i++) {
                double temp = 1.0 * n / (8 * i + 7);
                if (temp % 1.0 == 0) {
                    int num = 1;
                    while (num <= temp) {
                        if (num == temp) {
                            return true;
                        } else {
                            num *= 4;
                        }
                    }
                }
            }
            return false;
        }
    }

    private boolean isTwo(int n) {
        for (int i = 0; i < Math.sqrt(n); i++) {
            int temp = n - i * i;
            double a = Math.sqrt(temp);
            if (a % 1.0 == 0) {
                return true;
            }
        }
        return false;
    }
}