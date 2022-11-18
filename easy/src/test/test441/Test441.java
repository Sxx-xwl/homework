package test.test441;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。
 * 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
 * 阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * https://leetcode.cn/problems/arranging-coins/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test441
 * @create 2022-11-18-10:29
 */
public class Test441 {
    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(2147483647));
    }
}

class Solution {
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        long mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((1 + mid) * mid / 2 <= n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) r;
    }
}