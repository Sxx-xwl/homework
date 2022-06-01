package test.test020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sxx_27
 * @create 2022-01-18 17:59
 */
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。


示例 1：

输入：s = "()"
输出：true

示例 2：

输入：s = "()[]{}"
输出：true

示例 3：

输入：s = "(]"
输出：false

示例 4：

输入：s = "([)]"     "([)"
输出：false

示例 5：

输入：s = "{[]}"
输出：true

 */
public class Test020 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if ((s.length() % 2) != 0) {
            System.out.println(false);
            return;
        }
        String ss = s.substring(1, s.length() - 1);
        int times = ss.length() / 2;
        for (int i = 0; i < times; i++) {
            String replace = ss.replace("()", "");
            String replace1 = replace.replace("[]", "");
            String replace2 = replace1.replace("{}", "");
            ss = replace2;
        }
        if (ss.length() == 0) {
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }
}

// 91  93  40 41  123  125