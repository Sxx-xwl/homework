package test.test500;

import java.util.Arrays;

/**
 * 12210111011122000010020202
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * https://leetcode.cn/problems/keyboard-row/description/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test500
 * @create 2022-11-28-15:29
 */
public class Test500 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}

class Solution {
    public String[] findWords(String[] words) {
        String sKey = "12210111011122000010020202";
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            String cur = str.toLowerCase();
            int index = cur.charAt(0) - 'a', i = 1;
            char c = sKey.charAt(index);
            for (i = 1; i < str.length(); i++) {
                int temp = cur.charAt(i) - 'a';
                if (c != sKey.charAt(temp)) {
                    break;
                }
            }
            if (i == str.length()) {
                sb.append(str);
                sb.append(",");
            }
        }
        return sb.length() == 0 ? new String[0] : sb.toString().split(",");
    }
}