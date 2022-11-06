package test.test1678;

/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * https://leetcode.cn/problems/goal-parser-interpretation/
 *
 * @author sxx_xwl
 * @version 1.0.0
 * @className test.test1678
 * @create 2022-11-06-10:39
 */
public class Test1678 {
    public static void main(String[] args) {
        System.out.println(new Solution().interpret("G()(al)"));
    }
}

class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int len = command.length();
        for (int i = 0; i < len - 1; i++) {
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
            } else {
                sb.append("G");
            }
        }
        if (command.charAt(len - 1) == 'G') {
            sb.append('G');
        }
        return sb.toString();
    }
}