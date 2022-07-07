package top.top091;

import java.util.ArrayList;
import java.util.List;

/**
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * @Classname Top091
 * @Version 1.0.0
 * @Date 2022/7/7 13:43
 * @Created by sxx_xwl
 */
public class Top091 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("10011"));
        System.out.println(new Solution().numDecodings("301"));
        System.out.println(new Solution().numDecodings("06"));
        System.out.println(new Solution().numDecodings("2101"));
        System.out.println(new Solution().numDecodings("1123"));
        System.out.println(new Solution().numDecodings("207"));
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("230"));
    }
}

class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        if (chars[0] == '0' || s.contains("00")) {
            return 0;
        }
        int a = 1, b;
        int start = (chars[0] - '0') * 10 + (chars[1] - '0');
        if (start > 26 && chars[1] == '0') {
            return 0;
        }
        b = start <= 26 && chars[1] != '0' ? 2 : 1;
        int index = 2;
        while (index < chars.length) {
            int temp = a;
            a = b;
            int i = (chars[index - 1] - '0') * 10 + (chars[index] - '0');
            if (chars[index] == '0') {
                if (i > 26) {
                    return 0;
                }
                b = temp;
            } else if (i <= 26 && chars[index - 1] != '0') {
                b += temp;
            }
            index++;
        }
        return b;
    }

    public int numDecodings1(String s) {
        if (s.charAt(0) == '0' || s.contains("00")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int a = 1, b;
        int start = Integer.parseInt(s.substring(0, 2));
        if (start > 26 && s.charAt(1) == '0') {
            return 0;
        }
        b = start <= 26 && s.charAt(1) != '0' ? 2 : 1;
        int index = 2;
        while (index < s.length()) {
            int temp = a;
            a = b;
            int i = Integer.parseInt(s.substring(index - 1, index + 1));
            if (s.charAt(index) == '0') {
                if (i > 26) {
                    return 0;
                }
                b = temp;
            } else if (i <= 26 && s.charAt(index - 1) != '0') {
                b += temp;
            }
            index++;
        }
        return b;
    }
}
