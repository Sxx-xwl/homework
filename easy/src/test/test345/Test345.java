package test.test345;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test345
 * @create 2022-11-03-10:52
 */
public class Test345 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}

class Solution {
    public String reverseVowels(String s) {
        String temp = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int l = 0, len = s.length(), r = len - 1;
        while (l < r) {
            while (l < r && temp.indexOf(chars[l]) == -1) {
                l++;
            }
            while (l < r && temp.indexOf(chars[r]) == -1) {
                r--;
            }
            if (l < r && temp.indexOf(chars[l]) != -1 && temp.indexOf(chars[r]) != -1) {
                char cur = chars[l];
                chars[l] = chars[r];
                chars[r] = cur;
                l++;
                r--;
            }
        }
        return String.copyValueOf(chars);
    }
}