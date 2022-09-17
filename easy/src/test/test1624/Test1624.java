package test.test1624;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，
 * 计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * 子字符串 是字符串中的一个连续字符序列。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1624
 * @create 2022-09-17-20:28
 */
public class Test1624 {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] first = new int[26], last = new int[26];

    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        if (s.length() == 1) {
            return -1;
        }
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            if (first[temp] == -1) {
                first[temp] = i;
            }
            last[temp] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                res = Math.max(res, (last[i] - first[i] - 1));
            }
        }
        return res;
    }
}