package top.top017;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。
 * 注意 1 不对应任何字母。
 *
 * @Classname Top017
 * @Version 1.0.0
 * @Date 2022/6/26 20:07
 * @Created by sxx_xwl
 */
public class Top017 {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}

class Solution {
    String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return res;
        }
        search(digits, 0);
        return res;
    }

    private void search(String d, int index) {
        if (sb.length() == d.length()) {
            res.add(sb.toString());
            return;
        }
        char c = d.charAt(index);
        String s = str[c - '2'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            search(d, index + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}