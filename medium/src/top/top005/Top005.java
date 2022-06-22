package top.top005;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @Classname Top005
 * @Version 1.0.0
 * @Date 2022/6/22 14:12
 * @Created by sxx_xwl
 */
public class Top005 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("baabd"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len1 = 0, start1 = 0, len2 = 0, start2 = 0;
        for (int i = 0; i < chars.length; i++) {
            int search = search(chars, i, i);
            if (search > len1) {
                len1 = search;
                start1 = i;
            }
            if ((chars.length - i) < len1 / 2) {
                break;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            int search = search(chars, i, i + 1);
            if (search > len2) {
                len2 = search;
                start2 = i;
            }
            if ((chars.length - i) < len2 / 2) {
                break;
            }
        }
        return len1 >= len2 ? s.substring(start1 - len1 / 2, start1 + len1 / 2 + 1) : s.substring(start2 - (len2 - 1) / 2, start2 + len2 / 2 + 1);
    }

    private int search(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}