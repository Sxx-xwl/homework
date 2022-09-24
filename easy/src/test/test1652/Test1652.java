package test.test1652;

import java.util.Arrays;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 * 如果k > 0，将第i个数字用 接下来k个数字之和替换。
 * 如果k < 0，将第i个数字用 之前k个数字之和替换。
 * 如果k == 0，将第i个数字用0替换。
 * 由于code是循环的，code[n-1]下一个元素是code[0]，且code[0]前一个元素是code[n-1]。
 * 给你 循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1652
 * @create 2022-09-24-23:34
 */
public class Test1652 {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4, 3};
        int[] decrypt = new Solution().decrypt(code, 3);
        System.out.println(Arrays.toString(decrypt));
    }
}

class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] temp = new int[len];
        if (k == 0) {
            Arrays.fill(temp, 0);
            return temp;
        }
        int cur = 0;
        int begin, end;
        begin = k > 0 ? 1 : len + k;
        end = k > 0 ? k + 1 : len;
        while (cur < len) {
            int sum = 0;
            for (int i = begin + cur; i < end + cur; i++) {
                sum += code[i % len];
            }
            temp[cur++] = sum;
        }
        return temp;
    }
}