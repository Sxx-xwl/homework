package test.test1758;

/**
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。
 * 一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，
 * 那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1758
 * @create 2022-11-29-13:30
 */
public class Test1758 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minOperations(String s) {
        int len = s.length(), res1 = 0, res2 = 0;
        char[] c = new char[len + 1];
        for (int i = 0; i < len + 1; i++) {
            c[i] = i % 2 == 0 ? '1' : '0';
        }
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (temp != c[i]) res1++;
            if (temp != c[i + 1]) res2++;
        }
        return Math.min(res1, res2);
    }
}