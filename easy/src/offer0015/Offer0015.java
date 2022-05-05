package offer0015;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 *
 * @author sxx_27
 * @create 2022-04-27 20:56
 */
public class Offer0015 {

    public static void main(String[] args) {

        System.out.println(new Solution().hammingWeight(-3));

    }
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}