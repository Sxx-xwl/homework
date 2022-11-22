package test.test482;

/**
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。
 * 字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * 我们想要重新格式化字符串 s，使每一组包含 k 个字符，
 * 除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。
 * 此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 * 返回 重新格式化的许可密钥 。
 * https://leetcode.cn/problems/license-key-formatting/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test482
 * @create 2022-11-22-13:33
 */
public class Test482 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int index = 0, len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                index++;
                sb.append(c);
                if (index == k) {
                    index = 0;
                    sb.append('-');
                }
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        while (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}