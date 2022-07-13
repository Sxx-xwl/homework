package top.top139;

import java.util.*;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，
 * 并且字典中的单词可以重复使用。
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 *
 * @Classname Top139
 * @Version 1.0.0
 * @Date 2022/7/13 13:15
 * @Created by sxx_xwl
 */
public class Top139 {
    public static void main(String[] args) {
        List<String> w = new ArrayList<>();
        w.add("aaaa");
        w.add("aa");
        w.add("cats");
        w.add("dog");
        w.add("sand");
        w.add("and");
        w.add("cat");
        w.add("an");
        System.out.println(new Solution().wordBreak1("aaaaaa", w));
    }
}

class Solution {
    boolean isWord = false;
    Set<String> set;
    boolean[] isTrue;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        isTrue = new boolean[s.length() + 1];
        isTrue[0] = true;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (set.contains(sub)) {
                search(s, wordDict, i);
            }
        }
        return isWord;
    }

    private void search(String s, List<String> wordDict, int index) {
        if (++index == s.length()) {
            isWord = true;
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isWord) {
                return;
            }
            String sub = s.substring(index, i + 1);
            if (set.contains(sub) && !isTrue[i + 1]) {
                isTrue[i + 1] = true;
                search(s, wordDict, i);
            }
        }
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        int length = s.length();
        set = new HashSet<>(wordDict);
        isTrue = new boolean[s.length() + 1];
        isTrue[0] = true;
        s = ' ' + s;
        for (int i = 1; i <= length; i++) {
            for (int j = i; j > 0; j--) {
                String sub = s.substring(j, i + 1);
                if (isTrue[j - 1] && set.contains(sub)) {
                    isTrue[i] = true;
                    break;
                }
            }
        }
        return isTrue[length];
    }
}