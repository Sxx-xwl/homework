package test.test1784;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 * 如果 s中由连续若干个'1' 组成的字段数量不超过 1，返回 true 。否则，返回 false 。
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1784
 * @create 2022-10-10-15:03
 */
public class Test1784 {
    public static void main(String[] args) {
        String s = "010100001";
        String[] split = s.split("0");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        System.out.println(split.length);
    }
}

class Solution {
    public boolean checkOnesSegment(String s) {
        int flag = 0;
        if (s.charAt(0) == '1') {
            flag++;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1' && c != s.charAt(i - 1)) {
                flag++;
                if (flag > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}