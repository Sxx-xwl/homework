package test.test1704;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音
 * （'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。
 * 注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1704
 * @create 2022-11-11-10:18
 */
public class Test1704 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length, res = 0;
        for (int i = len / 2; i < len; i++) {
            char c1 = Character.toLowerCase(chars[i]);
            char c2 = Character.toLowerCase(chars[len - i - 1]);
            if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                res++;
            }
            if (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') {
                res--;
            }
        }
        return res == 0;
    }
}