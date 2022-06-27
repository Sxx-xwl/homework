package top.top022;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合
 *
 * @Classname Top022
 * @Version 1.0.0
 * @Date 2022/6/27 9:50
 * @Created by sxx_xwl
 */
public class Top022 {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}

class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return list;
        }
        search(n, n);
        return list;
    }

    private void search(int l, int r) {
        if (l == 0 && r == 0) {
            list.add(sb.toString());
            return;
        }
        if (r == l) {
            sb.append('(');
            search(l - 1, r);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (l > 0) {
                sb.append('(');
                search(l - 1, r);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            search(l, r - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}