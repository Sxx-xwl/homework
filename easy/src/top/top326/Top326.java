package top.top326;

/**
 * 给定一个整数，写一个函数来判断它是否是
 * 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * @author sxx_xwl
 * @create 2022-06-21-16:56
 */
public class Top326 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(45));
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        int t = 1;
        while (t < n && t < Integer.MAX_VALUE / 3) {
            t *= 3;
        }
        return t == n;
    }
}