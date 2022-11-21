package test.test476;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，
 * 再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，
 * 取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * https://leetcode.cn/problems/number-complement/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test476
 * @create 2022-11-21-10:24
 */
public class Test476 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findComplement(int num) {
        int temp = num, cur = 0;
        while (temp > 0) {
            temp >>= 1;
            cur = (cur << 1) + 1;
        }
        return cur ^ num;
    }
}