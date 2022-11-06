package test.test389;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * https://leetcode.cn/problems/find-the-difference/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test389
 * @create 2022-11-06-11:12
 */
public class Test389 {
    public static void main(String[] args) {

    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            res += tt[i] - ss[i];
        }
        res += tt[tt.length - 1];
        return (char) res;
    }
}