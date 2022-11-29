package test.test0201;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * https://leetcode.cn/problems/bitwise-and-of-numbers-range/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0201
 * @create 2022-11-29-15:03
 */
public class Test0201 {
    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(1, 2147483647));
    }
}

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int times = 0;
        while (left != right) {
            left= left>>1;
            right= right>>1;
            times++;
        }
        return left == 0 ? 0 : left << times;
    }
}