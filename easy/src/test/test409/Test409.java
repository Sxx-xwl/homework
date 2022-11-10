package test.test409;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * https://leetcode.cn/problems/longest-palindrome/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test409
 * @create 2022-11-10-13:31
 */
public class Test409 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[58];
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }
        int res = 0, addNum = 0;
        for (int i = 0; i < 58; i++) {
            int temp = counts[i];
            if (temp == 0) continue;
            if (temp % 2 == 1) {
                addNum = 1;
                res += temp - 1;
            } else res += temp;
        }
        return res + addNum;
    }
}