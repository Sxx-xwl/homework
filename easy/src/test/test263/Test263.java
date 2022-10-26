package test.test263;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test263
 * @create 2022-10-26-9:50
 */
public class Test263 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] f = {2, 3, 5};
        for (int num : f) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}