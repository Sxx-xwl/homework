package top.top131;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，
 * 请你将 s 分割成一些子串，
 * 使每个子串都是 回文串 。
 * 返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * @Classname Top131
 * @Version 1.0.0
 * @Date 2022/7/11 22:02
 * @Created by sxx_xwl
 */
public class Top131 {
    public static void main(String[] args) {
        System.out.println(new Solution().partition("babab"));
    }
}

class Solution {
    List<List<String>> listList = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        search(s, 0);
        return listList;
    }

    private void search(String s, int index) {
        if (index == s.length()) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPalindrome(sub)) {
                list.add(sub);
                search(s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }
}