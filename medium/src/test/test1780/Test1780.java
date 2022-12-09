package test.test1780;

/**
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1780
 * @create 2022-12-09-14:26
 */
public class Test1780 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}