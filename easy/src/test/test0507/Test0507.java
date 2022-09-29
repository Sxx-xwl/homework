package test.test0507;

/**
 * 对于一个正整数，
 * 如果它和除了它自身以外的所有 正因子 之和相等，
 * 我们称它为 「完美数」。
 * 给定一个整数n，如果是完美数，
 * 返回 true；否则返回 false
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0507
 * @create 2022-09-28-15:35
 */
public class Test0507 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}