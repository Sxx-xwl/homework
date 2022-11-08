package test.test1684;

/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * 请你返回 words 数组中 一致字符串 的数目。
 *https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1684
 * @create 2022-11-08-11:06
 */
public class Test1684 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] all = new int[26];
        for (char c : allowed.toCharArray()) {
            all[c - 'a']++;
        }
        int res = 0;
        for (String s : words) {
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (all[c - 'a'] == 0) break;
                if (j == s.length() - 1) res++;
            }
        }
        return res;
    }
}