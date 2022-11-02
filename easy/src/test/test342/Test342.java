package test.test342;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test342
 * @create 2022-11-02-20:14
 */
public class Test342 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(0));
        System.out.println(64 >> 1);
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int temp = (int) (Math.log(n) / Math.log(4));
        return temp * Math.log(4) == Math.log(n);
    }
}