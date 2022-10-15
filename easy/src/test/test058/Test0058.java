package test.test058;

/**
 * 给你一个字符串 s，由若干单词组成，
 * 单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test0058
 * @create 2022-10-15-22:29
 */
public class Test0058 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return len - i - 1;
            }
        }
        return len;
    }
}