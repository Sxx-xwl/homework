package test.test258;

/**
 * 给定一个非负整数 num，
 * 反复将各个位上的数字相加，
 * 直到结果为一位数。返回这个结果。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test258
 * @create 2022-10-25-22:57
 */
public class Test258 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
