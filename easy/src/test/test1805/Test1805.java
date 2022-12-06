package test.test1805;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。
 * 注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * https://leetcode.cn/problems/number-of-different-integers-in-a-string/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1805
 * @create 2022-12-06-10:42
 */
public class Test1805 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("a1b01c001"));
    }
}

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                sb.append(chars[i] - '0');
            } else {
                if (sb.length() != 0) {
                    set.add(trimStr(sb));
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            set.add(trimStr(sb));
        }
        return set.size();
    }

    private String trimStr(StringBuilder sb) {
        int index = 0;
        while (index < sb.length() - 1) {
            if (sb.charAt(index) == '0') {
                index++;
            } else {
                break;
            }
        }
        return sb.substring(index);
    }
}